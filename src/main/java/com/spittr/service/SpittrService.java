package com.spittr.service;

import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import com.spittr.repository.SpitterRepository;
import com.spittr.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SpittrService {

    @Autowired
    private SpitterRepository spitterRepository;
    @Autowired
    private SpittleRepository spittleRepository;


    @Transactional
    public List<Spitter> getAllSpitters() {
        return spitterRepository.findAll();
    }

    @Transactional
    public List<Spittle> getAllSpittles(){
        return spittleRepository.findAll();
    }
}



