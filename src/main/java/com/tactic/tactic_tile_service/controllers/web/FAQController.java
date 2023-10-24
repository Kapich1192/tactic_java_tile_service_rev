package com.tactic.tactic_tile_service.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FAQController {
    @GetMapping("/faq")
    public String getFaq() {
        return "faq";
    }
}
