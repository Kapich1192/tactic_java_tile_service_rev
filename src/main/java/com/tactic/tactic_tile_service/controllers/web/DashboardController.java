package com.tactic.tactic_tile_service.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.tactic.tactic_tile_service.config.Singleton.thisElement;

@Controller
public class DashboardController {
    @GetMapping("/")
    public String getDashboard(Model model) {
        if(thisElement != null) {
            model.addAttribute("el",thisElement);
        }
        return "dashboard";
    }
}
