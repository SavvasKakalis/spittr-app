package com.spittr.controller;

import com.spittr.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpittleController {

    @Autowired
    private SpittleService spittleService;

    @GetMapping("/spittles")
    public String listSpittles(Model model) {
        model.addAttribute("spittles", spittleService.getSpittles());
        return "spittles";
    }
}