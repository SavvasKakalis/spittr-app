import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class SpittrServiceImpl implements SpittrServiceDAO {

    private static final Logger logger = LoggerFactory.getLogger(SpittrServiceImpl.class);

    // HashMap that keeps information about the Spitter objects
    private Map<Integer, Spitter> spitters = new HashMap<>();

    // HashMap that keeps information about the Spittle objects
    private Map<Integer, Spittle> spittles = new HashMap<>();

    // counter of "spitters" HashMap that is increased every time a Spitter is created
    private Integer spitterId = 1;

    // counter of "spittles" HashMap that is increased every time a Spittle is created
    private Integer spittleId = 1;

    private final Connection connection = DbConnection.getConnection();

    public void createSpitter(Spitter spitter) {
        //spitters.put(spitterId++, spitter);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO spitter  "
                            + "(username, password, fullname) "
                            + "VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, spitter.getUsername());
            statement.setString(2, spitter.getPassword());
            statement.setString(3, spitter.getFullName());

            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to insert spitter into database", e);

        } finally {
            DbConnection.closeStatement(statement);
        }
    }

    public Spitter findSpitterByUsername(String username) {
        //return spitters.get(spitterId);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM spitter WHERE username = ?",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, username);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new Spitter(rs.getString("username"), rs.getString("password"), rs.getString("fullname"));
                }
            }
        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to retrieve spitter from database", e);

        } finally {
            DbConnection.closeStatement(statement);
        }
        return null;
    }

    public Map<Integer, Spitter> findAllSpitters() {
        //return spitters;
        Map<Integer, Spitter> spitters = new HashMap<>();
        int spitterId = 0;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM spitter");
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    spitters.put(spitterId++, new Spitter(rs.getString("username"), rs.getString("password"), rs.getString("fullname")));
                }
            }
        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to retrieve all the spitters from database", e);

        } finally {
            DbConnection.closeStatement(statement);
        }
        return spitters;
    }

    public void updateSpitter(Spitter spitter) {
        //spitters.put(spitterId, spitter);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE spitter SET username = ?, password = ?, fullname = ? WHERE username = ?",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, spitter.getUsername());
            statement.setString(2, spitter.getPassword());
            statement.setString(3, spitter.getFullName());
            statement.setString(4, spitter.getUsername());


            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to update spitter in database", e);

        } finally {
            DbConnection.closeStatement(statement);
        }
    }

    public void deleteSpitter(String spitterUsername) {
        //spitters.remove(spitterId);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM spitter WHERE username = ?",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, spitterUsername);

            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to delete spitter from database", e);

        } finally {
            DbConnection.closeStatement(statement);
        }
    }

    public void createSpittle(Spittle spittle) {
        //spittles.put(spittleId++, spittle);
        PreparedStatement statement = null;
        try {
            Timestamp timestamp = Timestamp.valueOf(spittle.getTimeSubmitted());

            statement = connection.prepareStatement(
                    "INSERT INTO spittle  "
                            + "(message, datetime, spitter) "
                            + "VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, spittle.getMessage());
            statement.setTimestamp(2, timestamp);
            statement.setString(3, spittle.getSpitter().getUsername());

            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to insert spittle into database", e);

        } finally {
            DbConnection.closeStatement(statement);
        }
    }

    public Spittle findSpittleByMessage(String message) {
        //return spittles.get(spittleId);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM spittle WHERE message = ?",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, message);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Timestamp timestamp = rs.getTimestamp("datetime");
                    LocalDateTime localDateTime = timestamp.toLocalDateTime();

                    Spitter spitter = findSpitterByUsername(rs.getString("spitter"));

                    return new Spittle(rs.getString("message"), localDateTime, spitter);
                }
            }
        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to retrieve spittle from database", e);

        } finally {
            DbConnection.closeStatement(statement);
        }
        return null;
    }

    public Map<Integer, Spittle> findSpittlesBySpitter(String searchedUsername) {
        Map<Integer, Spittle> spittlesBySpitter = new HashMap<>();
        int spittleId = 0;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM spittle WHERE spitter = ?");

            statement.setString(1, searchedUsername);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Timestamp timestamp = rs.getTimestamp("datetime");
                    LocalDateTime localDateTime = timestamp.toLocalDateTime();

                    Spitter spitter = findSpitterByUsername(searchedUsername);

                    spittlesBySpitter.put(spittleId++, new Spittle(rs.getString("message"), localDateTime, spitter));
                }
            }
        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to retrieve all spittle from database", e);

        } finally {
            DbConnection.closeStatement(statement);
        }
        return spittlesBySpitter;
    }

    public void updateSpittle(String message, Spittle spittle) {
        //spittles.put(spittleId, spittle);
        PreparedStatement statement = null;
        try {
            Timestamp timestamp = Timestamp.valueOf(spittle.getTimeSubmitted());

            statement = connection.prepareStatement("UPDATE spittle SET message = ?, datetime = ?, spitter = ? WHERE message = ?",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, spittle.getMessage());
            statement.setTimestamp(2, timestamp);
            statement.setString(3, spittle.getSpitter().getUsername());
            statement.setString(4, message);


            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to update spittle in database", e);

        } finally {
            DbConnection.closeStatement(statement);
        }
    }

    public void deleteSpittle(String message) {
        //spittles.remove(spittleId);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM spittle WHERE message = ?",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, message);

            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to delete spittle from database", e);

        } finally {
            DbConnection.closeStatement(statement);
        }
    }

    public Map<Integer, Spitter> getSpitters() {
        return spitters;
    }

    public void setSpitters(Map<Integer, Spitter> spitters) {
        this.spitters = spitters;
    }

    public Map<Integer, Spittle> getSpittles() {
        return spittles;
    }

    public void setSpittles(Map<Integer, Spittle> spittles) {
        this.spittles = spittles;
    }
}
