package com.spittr.controller;

import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import com.spittr.service.SpittrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/spittr")
@CrossOrigin
public class SpittrController {

    @Autowired
    private SpittrService spittrService;


    @GetMapping("/spitters")
    public List<Spitter> listSpitters(Model model) {
        return spittrService.getAllSpitters();
    }

    @GetMapping("/spittles")
    public List<Spittle> listSpittles(Model model) {
        return spittrService.getAllSpittles();
    }
}
