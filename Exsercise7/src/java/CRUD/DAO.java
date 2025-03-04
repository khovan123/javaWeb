package CRUD;

import java.sql.*;
import java.util.*;
import model.Student;

public class DAO {

    DBContext db = new DBContext();

    public List<Student> getAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        List<String> names = new ArrayList<>();
        Connection con = db.getConnection();
        String query1 = "select distinct name from MarkTBL";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query1);
        while (rs.next()) {
            names.add(rs.getString("name"));
        }
        names.forEach(name -> {
            try {
                Student std = new Student();
                std.setName(name);
                std.setMarks(this.getMarks(name));
                students.add(std);
            } catch (Exception e) {

            }
        });
        return students;
    }

    private Map<String, Double> getMarks(String name) throws SQLException {
        Map<String, Double> marks = new HashMap<>();
        Connection con = db.getConnection();
        String query = "select subject, mark from MarkTBL where name = ?";
        try (PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                marks.putIfAbsent(rs.getString("subject"), rs.getDouble("mark"));
            }
        }
        return marks;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        try {
            dao.getAll().forEach(std -> {
                System.out.println(std);
            });
        } catch (Exception e) {

        }
    }
}
