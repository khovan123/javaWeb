package CRUD;

import java.sql.*;
import java.util.*;
import model.Student;

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

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM StudentTBL";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            try {
                Student student = new Student();
                student.setId(rs.getInt("Id"));
                student.setName(rs.getString("Name"));
                student.setGender(rs.getBoolean("Gender"));
                student.setDob(rs.getDate("DOB"));
                students.add(student);
            } catch (SQLException e) {
            }
        }
        return students;
    }

    public void createStudent(Student student) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO StudentTBL(Id,Name,Gender,DOB) VALUES(?,?,?,?)");
        pstm.setInt(1, student.getId());
        pstm.setString(2, student.getName());
        pstm.setBoolean(3, student.isGender());
        pstm.setDate(4, student.getDob());
        pstm.execute();
    }

    public boolean checkExistedStudent(int id) throws SQLException {
        String query = "SELECT * FROM StudentTBL WHERE Id = " + String.valueOf(id);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs.next();
    }

    public Student getStudentById(int id) throws SQLException {
        String query = "SELECT * FROM StudentTBL WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Student(rs.getInt("Id"), rs.getString("Name"), Boolean.parseBoolean(rs.getString("Gender")), java.sql.Date.valueOf(rs.getString("DOB")));
                } else {
                    return null;
                }
            }
        }
    }

    public boolean deleteStudentById(int id) throws SQLException {
        String query = "DELETE FROM StudentTBL WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    public void updateStudent(Student student, int oldId) throws SQLException {
        String query = "UPDATE StudentTBL SET Id= ?, Name = ?, Gender = ?, DOB = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setBoolean(3, student.isGender());
            stmt.setDate(4, student.getDob());
            stmt.setInt(5, oldId);
            stmt.executeUpdate();
        }
    }

}
