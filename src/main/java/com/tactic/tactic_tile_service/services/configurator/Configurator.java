package com.tactic.tactic_tile_service.services.configurator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tactic.tactic_tile_service.models.elements.Element;

import java.io.*;

import static com.tactic.tactic_tile_service.config.Singleton.thisElement;

public interface Configurator {
    public static String path = "configure_service/tile_service.json";
    default void initConfigure() {
        new File("configure_service").mkdir();
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(thisElement);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(jsonResult);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Сохранение
    default void saveConfigure(){
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(thisElement);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(jsonResult);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Загрузка
    default boolean loadConfigure(){
        boolean result = true;
        new File("configure_service").mkdir();
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        String temp = "";
        String res = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(temp != null) {
                temp = reader.readLine();
                if(temp != null)
                    res += temp;
            }
            reader.close();
            thisElement = mapper.readValue(res, Element.class);
        } catch (IOException e) {
            result = false;
        }
        return result;
    }
}
