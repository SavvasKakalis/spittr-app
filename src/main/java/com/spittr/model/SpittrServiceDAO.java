package com.spittr.model;

import com.spittr.model.Spitter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpittrServiceDAO {

    void createSpitter(Spitter spitter);

    Spitter findSpitterByUsername(String username);

    List<Spitter> findAllSpitters();

    void updateSpitter(Spitter spitter);

    void deleteSpitter(int spitterId);

    void createSpittle(Spittle spittle);

    Spittle findSpittleByMessage(String message);

    List<Spittle> findSpittlesBySpitter(int spitterId);

    void updateSpittle(Spittle spittle);

    void deleteSpittle(int spittleId);

}
