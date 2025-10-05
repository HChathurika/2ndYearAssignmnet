package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {

    private static Connection conn = null;

    // Database configuration
    private static final String URL = "jdbc:mariadb://127.0.0.1:3306/currencydb";
    private static final String USER = "root";
    private static final String PASSWORD = "ASITHA@123";

    /**
     * Get a connection to the MariaDB database.
     *
     * @return Connection object
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Load MariaDB JDBC driver explicitly (optional for JDBC 4+)
                Class.forName("org.mariadb.jdbc.Driver");

                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Connected to MariaDB successfully.");
            } catch (ClassNotFoundException e) {
                System.err.println("❌ MariaDB JDBC Driver not found. Add mariadb-java-client.jar to your classpath.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("❌ Connection to MariaDB failed!");
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * Close the connection safely.
     */
    public static void terminate() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("✅ Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error closing connection.");
            e.printStackTrace();
        }
    }

    // Test main method
    public static void main(String[] args) {
        Connection testConn = MariaDbConnection.getConnection();
        if (testConn != null) {
            System.out.println("Database connection test successful!");
            terminate();
        } else {
            System.out.println("Database connection test failed!");
        }
    }
}
