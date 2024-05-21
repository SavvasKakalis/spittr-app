package com.spittr.controller;

import com.spittr.model.Spitter;
import com.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SpitterController {

    @Autowired
    private SpitterService spitterService;

    @GetMapping("/spitters")
    public String listSpitters(Model model) {
        List<Spitter> spitters = spitterService.getAllSpitters();
        model.addAttribute("spitters", spitters);
        return "spitters";
    }
}
