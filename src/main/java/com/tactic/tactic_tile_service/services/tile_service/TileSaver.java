package com.tactic.tactic_tile_service.services.tile_service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public interface TileSaver {
    default void saveTiles(int zoom, String[] leftUp, String[] rightDown) {
        Integer z1,x,y,x1,y1,x2,y2;
        z1 = zoom;
        for (int z = z1; z > 0; z--) {
            String[] leftUpTileNum = getTileNumber(Double.parseDouble(leftUp[0]),Double.parseDouble(leftUp[1]),z).split("/");
            String[] rightDownTileNum = getTileNumber(Double.parseDouble(rightDown[0]),Double.parseDouble(rightDown[1]),z).split("/");
            x1 = Math.min(Integer.parseInt(leftUpTileNum[1]),Integer.parseInt(rightDownTileNum[1]));
            x2 = Math.max(Integer.parseInt(leftUpTileNum[1]),Integer.parseInt(rightDownTileNum[1]));
            y1 = Math.min(Integer.parseInt(leftUpTileNum[2]),Integer.parseInt(rightDownTileNum[2]));
            y2 = Math.max(Integer.parseInt(leftUpTileNum[2]),Integer.parseInt(rightDownTileNum[2]));
            new File("tiles").mkdir();
            for (x = x1; x <= x2; x++) {
                for (y = y1; y<= y2; y++) {
                    if (!new File("tiles/%d/%d/%d.png".formatted(z,x,y)).exists()) {
                        byte[] img = getTitleFromWebsite(z, x, y);
                    }
                }
            }
        }
    }

    private byte[] getTitleFromWebsite(Integer z, Integer x, Integer y) {
        byte[] buffer = null;
        try{
            final String fileName = "tiles/"+z+"/"+x+"/"+y+".png";
            final String dirName = "tiles/%d/%d".formatted(z,x);
            File dir = new File(dirName);
            dir.mkdirs();
            String website;
//            String website = "https://cartodb-basemaps-a.global.ssl.fastly.net/light_all/"+z+"/"+x+"/"+y+".png";
//            String website = "https://a.tile.openstreetmap.org/"+z+"/"+x+"/"+y+".png";
            website = "https://mt0.google.com/vt/lyrs=y&hl=ru&z="+z+"&x="+x+"&y="+y+""; //гибрид
            //https://tile.openstreetmap.org/16/39628/20483.png     //оффициально коммерчески разрешен
            //https://mt0.google.com/vt/lyrs=s&hl=ru&z=16&x=39628&y=20483   //гугл спутник
            //https://mt0.google.com/vt/lyrs=m&hl=ru&z=16&x=39628&y=20483   //гугл схема
            //http://mt0.google.com/vt/lyrs=y&hl=ru&z=16&x=39628&y=20483    //гибрид
            //https://cartodb-basemaps-a.global.ssl.fastly.net/light_all/16/39628/20483.png //прикольный стиль https://cartodb-basemaps-a.global.ssl.fastly.net/#18/55.75451/-682.37324

            URL url = new URL(website);
            URLConnection hc = url.openConnection();
            hc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Intel core I3; en-US; rv:1.9.2.2)");
            final int len = hc.getContentLength();
            if (len == 0 ) return null;
            InputStream inputStream = hc.getInputStream();
            OutputStream outputStream = new FileOutputStream(fileName);
            buffer = new byte[len];
            int length = 0;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            inputStream.close();
            outputStream.close();

        } catch(Exception e) {

        }
        return buffer;
    }

    default String getTileNumber(final double lat, final double lon, final int zoom) {
        int xtile = (int)Math.floor( (lon + 180) / 360 * (1<<zoom) ) ;
        int ytile = (int)Math.floor( (1 - Math.log(Math.tan(Math.toRadians(lat)) + 1 / Math.cos(Math.toRadians(lat))) / Math.PI) / 2 * (1<<zoom) ) ;
        if (xtile < 0) {
            xtile = 0;
        }
        if (xtile >= (1 << zoom)) {
            xtile = ((1 << zoom) - 1);
        }
        if (ytile < 0) {
            ytile = 0;
        }
        if (ytile >= (1 << zoom)) {
            ytile = ((1 << zoom) - 1);
        }
        return("" + zoom + "/" + xtile + "/" + ytile);
    }
}
