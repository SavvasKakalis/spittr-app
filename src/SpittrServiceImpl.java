import java.sql.*;
import java.time.*;
import java.util.HashMap;
import java.util.Map;


public class SpittrServiceImpl implements SpittrServiceDAO {

    private Map<Integer, Spitter> spitters = new HashMap<>();
    private Map<Integer, Spittle> spittles = new HashMap<>();
    private Integer spitterId = 1;
    private Integer spittleId = 1;
    private final Connection connection = DbConnection.getConnection();

    public void createSpitter(Spitter spitter) throws SQLException {
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

        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public Spitter findSpitterByUsername(String username) throws SQLException {
        //return spitters.get(spitterId);
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM spitter WHERE username = ?",
                Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, username);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new Spitter(rs.getString("username"), rs.getString("password"), rs.getString("fullname"));
                }
            }
        }
        return null;
    }

    public Map<Integer, Spitter> findAllSpitters() throws SQLException {
        //return spitters;
        Map<Integer, Spitter> spitters = new HashMap<>();
        int spitterId = 0;

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM spitter")) {

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    spitters.put(spitterId++, new Spitter(rs.getString("username"), rs.getString("password"), rs.getString("fullname")));
                }
            }
        }
        return spitters;
    }

    public void updateSpitter(Spitter spitter) throws SQLException {
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
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void deleteSpitter(String spitterUsername) throws SQLException {
        //spitters.remove(spitterId);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM spitter WHERE username = ?",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, spitterUsername);

            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void createSpittle(Spittle spittle) throws SQLException {
        //spittles.put(spittleId++, spittle);
        PreparedStatement statement = null;
        try {
            Instant instant = spittle.getTimeSubmitted().atZone(ZoneId.systemDefault()).toInstant();
            Date date = (Date) Date.from(instant);

            statement = connection.prepareStatement(
                    "INSERT INTO spittle  "
                            + "(message, datetime, spitter) "
                            + "VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, spittle.getMessage());
            statement.setDate(2, date);
            statement.setString(3, spittle.getSpitter().getUsername());

            statement.executeUpdate();

        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public Spittle findSpittleByMessage(String message) throws SQLException {
        //return spittles.get(spittleId);
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM spittle WHERE message = ?",
                Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, message);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Date sqlDate = rs.getDate("datetime");
                    LocalDate localDate = sqlDate.toLocalDate();
                    LocalTime localTime = LocalTime.of(0, 0, 0); // You can adjust the time as needed
                    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

                    Spitter spitter = findSpitterByUsername(rs.getString("spitter"));

                    return new Spittle(rs.getString("message"), localDateTime, spitter);
                }
            }
        }
        return null;
    }

    public Map<Integer, Spittle> findSpittlesBySpitter(String searchedUsername) throws SQLException {
        Map<Integer, Spittle> spittlesBySpitter = new HashMap<>();
        for (Map.Entry<Integer, Spittle> entry : spittles.entrySet()) {
            if (entry.getValue().getSpitter().getUsername().equals(searchedUsername)) {
                spittlesBySpitter.put(entry.getKey(), entry.getValue());
            }
        }
        return spittlesBySpitter;
    }

    public void updateSpittle(String message, Spittle spittle) throws SQLException {
        //spittles.put(spittleId, spittle);
        PreparedStatement statement = null;
        try {
            Instant instant = spittle.getTimeSubmitted().atZone(ZoneId.systemDefault()).toInstant();
            Date date = (Date) Date.from(instant);

            statement = connection.prepareStatement("UPDATE spittle SET message = ?, datetime = ?, spitter = ? WHERE message = ?",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, spittle.getMessage());
            statement.setDate(2, date);
            statement.setString(3, spittle.getSpitter().getUsername());
            statement.setString(4, spittle.getMessage());


            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void deleteSpittle(String message) throws SQLException {
        //spittles.remove(spittleId);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM spittle WHERE message = ?",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, message);

            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
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
