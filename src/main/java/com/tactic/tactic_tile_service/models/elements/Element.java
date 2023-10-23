package com.tactic.tactic_tile_service.models.elements;

import java.util.HashMap;

public class Element {
    private TypeElement typeElement = TypeElement.TILE_SERVICE;
    private HashMap<String,String> identification = new HashMap<>() {{
        put("id","1");
        put("imei","tile_service_1");
    }};
    private HashMap<String,String> settings = new HashMap<>() {{
        put("ip","localhost");
        put("port","8090");
        put("source_saver","tiles/");
        put("source_downloader","tiles/");
        put("integration","false");
        put("server_ip_cn","localhost");
        put("server_port_cn","8082");
        put("print_monitoring","false");
        put("print_downloader","false");
        put("print_system","false");
        put("logger","false");
        put("terminal_mode","false");
        put("lang","RU");
    }};
}
