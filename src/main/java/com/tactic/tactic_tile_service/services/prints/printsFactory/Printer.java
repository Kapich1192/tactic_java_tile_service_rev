package com.tactic.tactic_tile_service.services.prints.printsFactory;

import java.util.Date;

import static com.tactic.tactic_tile_service.config.Singleton.thisElement;

public interface Printer {
    default void print(String src) {
        if (thisElement.getSettings().getOrDefault("print_system","false").equals("true")) {
            System.out.println(new Date(System.currentTimeMillis()) + " --> " + src);
        }
    }
}
