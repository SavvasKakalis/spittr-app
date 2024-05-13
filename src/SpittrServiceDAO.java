import java.util.Map;

public interface SpittrServiceDAO {

    void createSpitter(Spitter spitter);

    Spitter findSpitterByUsername(String username);

    Map<Integer, Spitter> findAllSpitters();

    void updateSpitter(Spitter spitter);

    void deleteSpitter(String spitterUsername);

    void createSpittle(Spittle spittle);

    Spittle findSpittleByMessage(String message);

    Map<Integer, Spittle> findSpittlesBySpitter(String searchedUsername);

    void updateSpittle(String message, Spittle spittle);

    void deleteSpittle(String message);

    Map<Integer, Spitter> getSpitters();

    void setSpitters(Map<Integer, Spitter> spitters);

    Map<Integer, Spittle> getSpittles();

    void setSpittles(Map<Integer, Spittle> spittles);
}
