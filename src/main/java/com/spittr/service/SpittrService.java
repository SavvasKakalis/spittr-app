package com.spittr.service;

import com.spittr.model.Spitter;
import com.spittr.model.Spittle;

import java.util.List;
import java.util.Optional;

public interface SpittrService {
    List<Spitter> getAllSpitters();
    Optional<Spitter> getSpitterById(int id);
    void saveSpitter(Spitter spitter);
    void deleteSpitterById(int id);
    List<Spittle> getAllSpittles();
}
