package com.spittr.controller;

import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import com.spittr.service.SpittrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/spittr")
@CrossOrigin
public class SpittrController {

    @Autowired
    private SpittrServiceImpl spittrService;


    @GetMapping("/spitters")
    public List<Spitter> listSpitters(Model model) {
        return spittrService.getAllSpitters();
    }

    @GetMapping("/spitters/{id}")
    public Optional<Spitter> getSpitterById(@PathVariable int id) {
        return spittrService.getSpitterById(id);
    }

    @PostMapping("/spitters")
    public void createSpitter(@RequestBody Spitter spitter){
        spittrService.saveSpitter(spitter);
    }

    @DeleteMapping("/spitters/{id}")
    public void deleteSpitterById(@PathVariable int id){
        spittrService.deleteSpitterById(id);
    }

    @GetMapping("/spittles")
    public List<Spittle> listSpittles(Model model) {
        return spittrService.getAllSpittles();
    }

}
