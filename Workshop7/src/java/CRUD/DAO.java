
package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class DAO {
private final static String URL = "jdbc:sqlserver://MINHDEV\\SQLEXPRESS:1433;databaseName=DB_PRJ301;encrypt=true;trustServerCertificate=true;zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String USER = "minh";
    private final static String PASSWORD = "1807";
    private final static Connection connection = getConnection();

    private static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public User select(String userName, String password) throws SQLException {
        String query = "SELECT * FROM IUserTBL WHERE username = ? AND password = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, userName);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getString("username"),rs.getString("password"));
                } else {
                    return null;
                }
            }
        }
    }
}
