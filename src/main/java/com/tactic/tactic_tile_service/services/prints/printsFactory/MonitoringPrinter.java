package com.tactic.tactic_tile_service.services.prints.printsFactory;

import static com.tactic.tactic_tile_service.config.Singleton.thisElement;

public interface MonitoringPrinter {
    default void printSystemMonitoring() {
        if(thisElement != null &&
           thisElement.getSettings().getOrDefault("print_monitoring","false").equals("true")) {
            System.out.println("-----------------------------------------------------------------------------");
            if(thisElement.getSettings().getOrDefault("lang","RU").equals("RU")) {
                System.out.println("Тип сервиса:                          ");
                System.out.println("IMEI сервиса:                         ");
                System.out.println("Id сервиса:                           ");
                System.out.println("Статус системы:                       ");
                System.out.println();
                System.out.println("Ip адрес:                             ");
                System.out.println("Порт:                                 ");
                System.out.println("Статус интеграции:                    ");
                System.out.println("Статус отправителя:                   ");
                System.out.println("Ip адрес сервера:                     ");
                System.out.println("Порт сервера:                         ");
                System.out.println();
                System.out.println("Терминальный режим:                   ");
                System.out.println("Вывод в консоль мониторинга:          ");
                System.out.println("Вывод в консоль системных сообщений:  ");
                System.out.println("Вывод в консоль информации о сервисе: ");
                System.out.println("Логирование:                          ");
                System.out.println("Язык:                                 ");
                System.out.println();

            } else if(thisElement.getSettings().getOrDefault("lang","RU").equals("ENG")) {
                System.out.println("System work");
            }
            System.out.println("-----------------------------------------------------------------------------");
        }
    }
}
