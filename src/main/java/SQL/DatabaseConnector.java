package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "url",
                "postgres",
                "password");
    }

    public static void createTable() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS backtodb.user" +
                    "(" +
                    "id serial primary key, " +
                    "username varchar(50) unique, " +
                    "password varchar(50))";
            statement.executeUpdate(sql);

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error creating table: " + ex.getMessage());
        }
    }

    public static void insertUser(String username, String password) throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO backtodb.user(username, password) VALUES ('" + username + "', '" + password + "')";
            statement.execute(sql);
        }
    }
}
