package com.tactic.tactic_tile_service.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TileSaverController {
    @GetMapping("/save_map")
    public String getSaveMap() {
        return "map_saver";
    }
}
