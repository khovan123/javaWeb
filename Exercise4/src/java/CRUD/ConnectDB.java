
package CRUD;

import java.sql.*;
public class ConnectDB {
private final static String url = "jdbc:sqlserver://MINHDEV\\SQLEXPRESS:1433;databaseName=DB_PRJ301;encrypt=true;trustServerCertificate=true;zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String user = "minh";
    private final static String password = "1807";
    public final static Connection connection = getConnection();

    private static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}
