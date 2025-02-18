
package CRUD;

import java.util.ArrayList;
import model.Student;

public interface IStudentDAO {
    ArrayList<Student> getStudents();
    
    void addStudent(Student student);
    
    void updateStudent(Student student);
    
    void deleteStudent(String id);

}
