package CRUD;

import java.sql.*;
import java.util.*;
import model.Product;

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

    public ArrayList<Product> getAllProduct() throws SQLException {
        ArrayList<Product> productList = new ArrayList<>();
        String query = "Select * From ProductTBL";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            try {
                Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"));
                productList.add(product);
            } catch (SQLException e) {

            }
        }
        return productList;
    }

    public static void main(String[] args) {
        DAO productDao = new DAO();
        try {
            productDao.getAllProduct().forEach(product -> {
                System.out.println(product.toString());
            });
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
