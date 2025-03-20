package connectDB;

import java.sql.*;

public class DBConnection {

    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://MINHDEV\\SQLEXPRESS:1433;databaseName=MilkDB;encrypt=true;trustServerCertificate=true;zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static String user = "minh";
    private static String pass = "1807";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Database connected successfully");
            }
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            throw new SQLException("Driver not found");
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            throw e;
        }
    }
}
