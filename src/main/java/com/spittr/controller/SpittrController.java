package com.spittr.controller;

import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import com.spittr.service.SpittrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SpittrController {

    @Autowired
    private SpittrService spittrService;


    @GetMapping("/spitters")
    public String listSpitters(Model model) {
        List<Spitter> spitters = spittrService.getAllSpitters();
        model.addAttribute("spitters", spitters);
        return "spitters";
    }

    @GetMapping("/spittles")
    public String listSpittles(Model model) {
        List<Spittle> spittles = spittrService.getAllSpittles();
        model.addAttribute("spittles", spittles);
        return "spittles";
    }
}
