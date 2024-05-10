import java.sql.SQLException;
import java.util.Map;

public interface SpittrServiceDAO {

    void createSpitter(Spitter spitter) throws SQLException;

    Spitter findSpitterByUsername(String username) throws SQLException;

    Map<Integer, Spitter> findAllSpitters() throws SQLException;

    void updateSpitter(Spitter spitter) throws SQLException;

    void deleteSpitter(String spitterUsername) throws SQLException;

    void createSpittle(Spittle spittle) throws SQLException;

    Spittle findSpittleByMessage(String message) throws SQLException;

    Map<Integer, Spittle> findSpittlesBySpitter(String searchedUsername) throws SQLException;

    void updateSpittle(String message, Spittle spittle) throws SQLException;

    void deleteSpittle(String message) throws SQLException;

    Map<Integer, Spitter> getSpitters();

    void setSpitters(Map<Integer, Spitter> spitters);

    Map<Integer, Spittle> getSpittles();

    void setSpittles(Map<Integer, Spittle> spittles);
}
