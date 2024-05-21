package com.spittr.controller;

import com.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpitterController {

    @Autowired
    private SpitterService spitterService;

    @GetMapping("/spitters")
    public String listSpitters(Model model) {
        model.addAttribute("spitters", spitterService.getSpitters());
        return "spitters";
    }
}
