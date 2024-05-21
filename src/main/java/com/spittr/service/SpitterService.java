package com.spittr.service;

import com.spittr.model.Spitter;
import com.spittr.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpitterService {

    @Autowired
    private SpitterRepository spitterRepository;

    public List<Spitter> getAllSpitters() {
        return spitterRepository.findAll();
    }
}



