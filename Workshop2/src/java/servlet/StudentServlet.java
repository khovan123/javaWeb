package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;
import model.Student;

public class StudentServlet extends HttpServlet {

    private ArrayList<Student> studentList = new ArrayList<>();

    private boolean isExited(int id) {
        return search(p -> p.getId() == id) != null;
    }

    private Student search(Predicate<Student> p) {
        for (Student student : studentList) {
            if (p.test(student)) {
                return student;
            }
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("tablePage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd");
            int id = Integer.parseInt((String) request.getParameter("id"));
            String name = (String) request.getParameter("name");
            Date dob = _sdf.parse((String) request.getParameter("dob"));
            boolean gender = request.getParameter("gender").equals("male");
            Student student = new Student(id, name, gender, dob);
            if (isExited(id)) {
                request.setAttribute("student", student);
                request.getRequestDispatcher("inputPage.jsp").forward(request, response);
                return;
            }
            studentList.add(student);
        } catch (NumberFormatException | ParseException e) {

        }
        response.sendRedirect("StudentServlet");
    }
}
