package main.java;

import com.atomikos.icatch.jta.UserTransactionImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class SpittrServiceImpl implements main.java.SpittrServiceDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJPADemo");

    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    // Obtain UserTransaction instance from JTA implementation (e.g., Atomikos)
    UserTransaction userTransaction = new UserTransactionImp();

    private static final Logger logger = LoggerFactory.getLogger(SpittrServiceImpl.class);

    // HashMap that keeps information about the Spitter objects
    private Map<Integer, main.java.Spitter> spitters = new HashMap<>();

    // HashMap that keeps information about the Spittle objects
    private Map<Integer, main.java.Spittle> spittles = new HashMap<>();

    // counter of "spitters" HashMap that is increased every time a Spitter is created
    private Integer spitterId = 1;

    // counter of "spittles" HashMap that is increased every time a Spittle is created
    private Integer spittleId = 1;

    private final Connection connection = main.java.DbConnection.getConnection();


    public void createSpitter(main.java.Spitter spitter) {
        //spitters.put(spitterId++, spitter);
        /*PreparedStatement statement = null;
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
        }*/
        try {
            userTransaction.begin();
            entityManager.persist(spitter);
            userTransaction.commit();
        } catch (Exception e) {
            rollbackTransaction(userTransaction);
            // Log the exception or handle it appropriately
        }

    }

    private void rollbackTransaction(UserTransaction userTransaction) {
        try {
            if (userTransaction != null && userTransaction.getStatus() == javax.transaction.Status.STATUS_ACTIVE) {
                userTransaction.rollback();
            }
        } catch (Exception ex) {
            // Log the rollback failure or handle it appropriately
        }
    }

    public main.java.Spitter findSpitterByUsername(String username) {
        //return spitters.get(spitterId);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM spitter WHERE username = ?",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, username);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new main.java.Spitter(rs.getString("username"), rs.getString("password"), rs.getString("fullname"));
                }
            }
        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to retrieve spitter from database", e);

        } finally {
            main.java.DbConnection.closeStatement(statement);
        }
        return null;
    }

    public Map<Integer, main.java.Spitter> findAllSpitters() {
        //return spitters;
        Map<Integer, main.java.Spitter> spitters = new HashMap<>();
        int spitterId = 0;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM spitter");
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    spitters.put(spitterId++, new main.java.Spitter(rs.getString("username"), rs.getString("password"), rs.getString("fullname")));
                }
            }
        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to retrieve all the spitters from database", e);

        } finally {
            main.java.DbConnection.closeStatement(statement);
        }
        return spitters;
    }

    public void updateSpitter(main.java.Spitter spitter) {
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
            main.java.DbConnection.closeStatement(statement);
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
            main.java.DbConnection.closeStatement(statement);
        }
    }

    public void createSpittle(main.java.Spittle spittle) {
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
            main.java.DbConnection.closeStatement(statement);
        }
    }

    public main.java.Spittle findSpittleByMessage(String message) {
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

                    main.java.Spitter spitter = findSpitterByUsername(rs.getString("spitter"));

                    return new main.java.Spittle(rs.getString("message"), localDateTime, spitter);
                }
            }
        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to retrieve spittle from database", e);

        } finally {
            main.java.DbConnection.closeStatement(statement);
        }
        return null;
    }

    public Map<Integer, main.java.Spittle> findSpittlesBySpitter(String searchedUsername) {
        Map<Integer, main.java.Spittle> spittlesBySpitter = new HashMap<>();
        int spittleId = 0;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM spittle WHERE spitter = ?");

            statement.setString(1, searchedUsername);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Timestamp timestamp = rs.getTimestamp("datetime");
                    LocalDateTime localDateTime = timestamp.toLocalDateTime();

                    main.java.Spitter spitter = findSpitterByUsername(searchedUsername);

                    spittlesBySpitter.put(spittleId++, new main.java.Spittle(rs.getString("message"), localDateTime, spitter));
                }
            }
        } catch (SQLException e) {
            logger.error("Error executing SQL", e);
            throw new RuntimeException("Failed to retrieve all spittle from database", e);

        } finally {
            main.java.DbConnection.closeStatement(statement);
        }
        return spittlesBySpitter;
    }

    public void updateSpittle(String message, main.java.Spittle spittle) {
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
            main.java.DbConnection.closeStatement(statement);
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
            main.java.DbConnection.closeStatement(statement);
        }
    }

    public Map<Integer, main.java.Spitter> getSpitters() {
        return spitters;
    }

    public void setSpitters(Map<Integer, main.java.Spitter> spitters) {
        this.spitters = spitters;
    }

    public Map<Integer, main.java.Spittle> getSpittles() {
        return spittles;
    }

    public void setSpittles(Map<Integer, main.java.Spittle> spittles) {
        this.spittles = spittles;
    }
}
