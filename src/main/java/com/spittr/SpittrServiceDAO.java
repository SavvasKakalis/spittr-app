package main.java.com.spittr;

import java.util.List;

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
