package com.tactic.tactic_tile_service.controllers.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;

import static com.tactic.tactic_tile_service.config.Singleton.thisElement;

@RestController
public class TileServerRestController {
    @GetMapping(value = "/tiles/{z}/{x}/{y}.png", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getSingleTile(@PathVariable("z") String z,
                                           @PathVariable("x") String x,
                                           @PathVariable("y") String y) {
        FileInputStream str;
        String pathVariable = thisElement.getSettings().getOrDefault("path_downloader","tiles");
        final String fileName = pathVariable + "/" + z + "/" + x + "/" + y + ".png";
        File file = new File(fileName);
        byte[] img = null;
        try {
            if (file.exists()) {
                img = new byte[(int) file.length()];
                str = new FileInputStream(file);
                str.read(img);
                str.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(img);
    }
}
