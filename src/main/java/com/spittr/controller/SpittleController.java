package com.spittr.controller;

import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import com.spittr.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SpittleController {

    @Autowired
    private SpittleService spittleService;

    @GetMapping("/spittles")
    public String listSpittles(Model model) {
        List<Spittle> spittles = spittleService.getAllSpittles();
        model.addAttribute("spittles", spittles);
        return "spittles";
    }
}