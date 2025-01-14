
import CRUD.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import model.Student;

@WebServlet(urlPatterns = {"/student/list", "/student/delete", "/student/updateList"})
public class StudentListServlet extends HttpServlet {

    private static DAO studentDao = new DAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("studentList");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Age</th>");
            out.println("<th>Email</th>");
            out.println("<th>Actions</th>");
            out.println("</tr>");

            if (studentList != null) {
                for (Student student : studentList) {
                    out.println("<tr>");
                    out.println("<td>" + student.getId() + "</td>");
                    out.println("<td>" + student.getName() + "</td>");
                    out.println("<td>" + (student.isGender() ? "Male" : "Female") + "</td>");
                    out.println("<td>" + student.getDob() + "</td>");
                    out.println("<td>");
                    out.println("<a href='../student/update?id=" + student.getId() + "'>Update</a> ");
                    out.println("<a href='../student/delete?id=" + student.getId() + "'>Delete</a>");
                    out.println("</td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<tr><td colspan='5'>No students found</td></tr>");
            }
            out.println("</table>");
            out.println("<a href=\"../student/create\">Create</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void processError(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Page Error 405</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h1>Some thing went wrong</h1>");
            out.println("<p>" + e.getLocalizedMessage() + "</p>");
            out.println("<div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getRequestURI().endsWith("/delete")) {
            String deleteId = request.getParameter("id");
            if (deleteId != null) {
                try {
                    int id = Integer.parseInt(deleteId);
                    boolean deleted = studentDao.deleteStudentById(id);
                    if (deleted) {
                        response.sendRedirect(request.getContextPath() + "/student/list");
                    } else {
                        processRequest(request, response);
                    }
                } catch (ServletException | IOException | NumberFormatException | SQLException e) {
                    processError(request, response, e);
                }
            }
        } else {
            try {
                ArrayList<Student> studentList = new ArrayList<>(studentDao.getAllStudents());
                request.setAttribute("studentList", studentList);
                processRequest(request, response);
            } catch (ServletException | IOException | SQLException e) {
                processError(request, response, e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getRequestURI().endsWith("/updateList")) {
            try {
                int oldId = Integer.parseInt(request.getParameter("oldId"));
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean gender = request.getParameter("gender").equals("male");
                Date date = java.sql.Date.valueOf(request.getParameter("dob"));
                Student student = new Student(id, name, gender, date);
                if (oldId != id && studentDao.checkExistedStudent(id)) {
                    response.sendRedirect(request.getContextPath()
                            + "/student/update?error=Id+was+existed&id=" + oldId);
                    return;
                }
                studentDao.updateStudent(student, oldId);
                response.sendRedirect(request.getContextPath() + "/student/list");
            } catch (IOException | NumberFormatException | SQLException e) {
                processError(request, response, e);
            }
        } else {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean gender = request.getParameter("gender").equals("male");
                Date date = java.sql.Date.valueOf(request.getParameter("dob"));
                Student student = new Student(id, name, gender, date);
                if (studentDao.checkExistedStudent(id)) {
                    response.sendRedirect(request.getContextPath()
                            + "/student/create?error=Id+was+existed");
                    return;
                }
                studentDao.createStudent(student);
                response.sendRedirect(request.getContextPath() + "/student/list");
            } catch (IOException | NumberFormatException | SQLException e) {
                processError(request, response, e);
            }
        }
    }
}
