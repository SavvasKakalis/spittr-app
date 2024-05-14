package main.java;

import com.mysql.cj.jdbc.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

    private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);

    public static final String URL = "jdbc:mysql://localhost:3306/spittrdb";
    public static final String USER = "root";
    public static final String PASS = "4k78bshhM123-";

    /**
     * Get a connection to database
     *
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                logger.error("Failed to close PreparedStatement", e);
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = DbConnection.getConnection();
    }

}