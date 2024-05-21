package com.spittr.service;

import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import com.spittr.repository.SpittleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpittleService {

    @Autowired
    private SpittleRepository spittleRepository;

    public List<Spittle> getAllSpittles() {
        return spittleRepository.findAll();
    }
}
