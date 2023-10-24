/*=====================================================================================================================*/
/*                                                                                      by: Stupor                     */
/*                                                                                      copyright:                     */
/*                                                                                      platform: Spring Web           */
/*                                                                                      developer: Prigodich Dmitriy;  */
/*                                                                                      developer: ;                   */
/*                                                                                      version: 1.0;                  */
/* Description:                                                                                                        */
/* Класс веб-контроллер для рабочей панели.                                                                            */
/*=====================================================================================================================*/
package com.tactic.tactic_tile_service.services.tile_counter;

import java.io.File;

import java.util.HashMap;

public interface TileCounter {
    default HashMap<String, Integer> tileCount(String path) {
        long start = System.currentTimeMillis();
        String[] x, y, z;
        HashMap<String, Integer> result = new HashMap<>() {{
            for(int i = 0; i <= 21; i++) {
                put("n" + i, 0);
            }
        }};
        new File(path).mkdirs();
        File temp = new File(path);
        z = temp.list();


        int counter = 0;
        if(z != null) {
            for (String s : z) {
                counter = 0;
                y = new File(path + "/" + s).list();
                if(y != null) {
                    for (String f : y) {
                        x = new File(path + "/" + s + "/" + f).list();
                        if (x != null) {
                            counter += x.length;
                        }
                    }
                }
                if(result.keySet().contains("n" + s))
                    result.put("n"+s,counter);
            }
        }

        long end = System.currentTimeMillis();
        return result;
    }
}
