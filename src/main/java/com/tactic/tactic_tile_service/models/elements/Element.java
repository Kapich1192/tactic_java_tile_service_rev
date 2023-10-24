package com.tactic.tactic_tile_service.models.elements;

import com.tactic.tactic_tile_service.services.configurator.Configurator;
import com.tactic.tactic_tile_service.services.tile_counter.TileCounter;

import java.util.HashMap;
import java.util.Objects;

public class Element implements Configurator, TileCounter {
    private TypeElement typeElement;
    private HashMap<String,String> identification;
    private HashMap<String,String> settings;

    public Element() {}

    public Element(TypeElement typeElement, HashMap<String, String> identification, HashMap<String, String> settings) {
        this.typeElement = typeElement;
        this.identification = identification;
        this.settings = settings;
    }

    public void initialize() {
        if(!loadConfigure()) {
            typeElement = TypeElement.TILE_SERVICE;
            identification = new HashMap<>() {{
                put("id","1");
                put("imei","tile_service_1");
            }};
            settings = new HashMap<>() {{
                put("ip","localhost");
                put("port","8090");
                put("path_saver","tiles");
                put("path_downloader","tiles");
                put("integration","false");
                put("server_ip_cn","localhost");
                put("server_port_cn","8082");
                put("print_monitoring","false");
                put("print_downloader","false");
                put("print_system","false");
                put("logger","false");
                put("terminal_mode","false");
                put("lang","RU");
                put("tile_server","true");
            }};
            initConfigure();
        }

    }

    public TypeElement getTypeElement() {
        return typeElement;
    }

    public void setTypeElement(TypeElement typeElement) {
        this.typeElement = typeElement;
    }

    public HashMap<String, String> getIdentification() {
        return identification;
    }

    public void setIdentification(HashMap<String, String> identification) {
        this.identification = identification;
    }

    public HashMap<String, String> getSettings() {
        return settings;
    }

    public void setSettings(HashMap<String, String> settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "Element{" +
                "typeElement=" + typeElement +
                ", identification=" + identification +
                ", settings=" + settings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return typeElement == element.typeElement && Objects.equals(identification, element.identification) && Objects.equals(settings, element.settings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeElement, identification, settings);
    }
}
