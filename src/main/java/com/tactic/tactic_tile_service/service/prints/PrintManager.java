package com.tactic.tactic_tile_service.service.prints;

import com.tactic.tactic_tile_service.service.prints.printsFactory.PrintsFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class PrintManager {
    public static PrintsFactory printer = new PrintsFactory();
    @Scheduled(fixedRate = 1000l)
    public void printMonitoring(){
        printer.printSystemMonitoring();
    }
}
