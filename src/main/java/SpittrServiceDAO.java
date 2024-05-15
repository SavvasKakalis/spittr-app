package main.java;

import java.util.List;
import java.util.Map;

public interface SpittrServiceDAO {

    void createSpitter(Spitter spitter);

    Spitter findSpitterByUsername(String username);

    List<Spitter> findAllSpitters();

    void updateSpitter(Spitter spitter);

    void deleteSpitter(int spitterId);

    void createSpittle(Spittle spittle);

    Spittle findSpittleByMessage(String message);

    List<Spittle> findSpittlesBySpitter(String searchedUsername);

    void updateSpittle(Spittle spittle);

    void deleteSpittle(int spittleId);

}
