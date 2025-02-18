package CRUD;

import java.sql.*;
import java.util.ArrayList;
import model.Student;

public class StudentDAO implements IStudentDAO {

    @Override
    public ArrayList<Student> getStudents() {
        ArrayList<Student> studentList = new ArrayList<>();
        String query = "SELECT * FROM StudentSTBL ORDER BY id";
        try {
            ConnectDB.connection.setAutoCommit(true);
            Statement stmt = ConnectDB.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ConnectDB.connection.commit();
            while (rs.next()) {
                Student student = new Student(rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            return null;
        }
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        String query = "INSERT INTO StudentSTBL(firstName,lastName,email) VALUES (?,?,?)";
        try (PreparedStatement pstm = ConnectDB.connection.prepareStatement(query)) {
            pstm.setString(1, student.getFirstName());
            pstm.setString(2, student.getLastName());
            pstm.setString(3, student.getEmail());
            pstm.execute();
        } catch (Exception e) {

        }
    }

    @Override
    public void updateStudent(Student student) {
        String query = "UPDATE StudentSTBL SET firstName = ?, lastName = ?, email = ? WHERE id = ?";
        try (PreparedStatement pstm = ConnectDB.connection.prepareStatement(query)) {
            pstm.setString(1, student.getFirstName());
            pstm.setString(2, student.getLastName());
            pstm.setString(3, student.getEmail());
            pstm.setInt(4, 0);
            pstm.executeUpdate();
        } catch (Exception e) {

        }
    }

    @Override
    public void deleteStudent(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        System.out.println(studentDAO.getStudents());
        studentDAO.addStudent(new Student("Quoc Minh", "Phan Nguyen", "pnqm@fpt.edu.vn"));
        System.out.println(studentDAO.getStudents());
    }

}
