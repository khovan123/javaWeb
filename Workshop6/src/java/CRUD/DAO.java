package CRUD;

import java.sql.*;
import java.util.*;
import model.Person;

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

    public ArrayList<Person> getAll(int pageIndex, int pageSize) throws SQLException {
        ArrayList<Person> personList = new ArrayList<>();
        String query = "SELECT * FROM DummyTBL ORDER BY ID ASC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, (pageIndex - 1) * pageSize);
            pstm.setInt(2, pageSize);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    personList.add(new Person(rs.getInt("ID"), rs.getString("Name")));
                }
            }
        }
        return personList;
    }

    public int count() throws SQLException {
        String query = "SELECT Count(ID) AS Quantity FROM DummyTBL";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs.next() ? rs.getInt("Quantity") : 0;
    }
}
