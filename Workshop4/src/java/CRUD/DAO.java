package CRUD;

import java.sql.*;
import java.util.*;

public class DAO {

    private final static String url = "jdbc:sqlserver://MINHDEV\\SQLEXPRESS:1433;databaseName=DB_PRJ301;encrypt=true;trustServerCertificate=true;zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String user = "minh";
    private final static String password = "1807";
    private final static Connection connection = getConnection();

    private static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public String select(String userName, String password) throws SQLException {
        String query = "SELECT * FROM UserTBL WHERE Username = ? AND Password = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, userName);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("DisplayName");
                } else {
                    return null;
                }
            }
        }
    }

}
