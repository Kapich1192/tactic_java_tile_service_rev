package com.tactic.tactic_tile_service.service.prints.printsFactory;

import static com.tactic.tactic_tile_service.config.Singleton.thisElement;

public interface MonitoringPrinter {
    default void printSystemMonitoring() {
        if(thisElement != null &&
           thisElement.getSettings().getOrDefault("print_monitoring","false").equals("true")) {
            System.out.println("-----------------------------------------------------------------------------");
            if(thisElement.getSettings().getOrDefault("lang","RU").equals("RU")) {
                System.out.println("Система работает");
            } else if(thisElement.getSettings().getOrDefault("lang","RU").equals("ENG")) {
                System.out.println("System work");
            }
            System.out.println("-----------------------------------------------------------------------------");
        }
    }
}
