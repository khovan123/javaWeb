
import CRUD.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import model.Student;

@WebServlet(urlPatterns = {"/student/create", "/student/update"})

public class StudentCreateServlet extends HttpServlet {

    private static DAO studentDao = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && request.getRequestURI().endsWith("/update")) {
            try {
                Student student = studentDao.getStudentById(Integer.parseInt(idStr));
                if (student != null) {
                    request.setAttribute("student", student);
                    request.setAttribute("_id", student.getId());
                    request.getRequestDispatcher("../inputPage.jsp").forward(request, response);
                } else {
                    response.sendRedirect("../student/list");
                }
            } catch (NumberFormatException | SQLException e) {
                response.sendRedirect("../student/list");

            }
        } else if (request.getRequestURI().endsWith("/create?") || request.getRequestURI().endsWith("/create")) {
            request.getRequestDispatcher("../inputPage.jsp").forward(request, response);
        } else {
            response.sendRedirect("../student/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("_id");
        if (idStr != null && request.getRequestURI().endsWith("/update")) {
            try {
                int _id = Integer.parseInt(request.getParameter("_id"));
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean gender = request.getParameter("gender").equals("male");
                Date date = java.sql.Date.valueOf(request.getParameter("dob"));
                Student student = new Student(id, name, gender, date);
                if (_id != id && studentDao.checkExistedStudent(id)) {
                    request.setAttribute("student", student);
                    request.setAttribute("_id", _id);
                    request.setAttribute("error", "Id was existed!");
                    request.getRequestDispatcher("../inputPage.jsp").forward(request, response);
                } else {
                    studentDao.updateStudent(student, _id);
                    response.sendRedirect(request.getContextPath() + "/student/list");
                }
            } catch (NumberFormatException | SQLException e) {
                response.sendRedirect(request.getContextPath() + "/student/list");
            }
        } else if (request.getRequestURI().endsWith("/create?") || request.getRequestURI().endsWith("/create")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean gender = request.getParameter("gender").equals("male");
                Date date = java.sql.Date.valueOf(request.getParameter("dob"));
                Student student = new Student(id, name, gender, date);
                if ( studentDao.checkExistedStudent(id)) {
                    request.setAttribute("student", student);
                    request.setAttribute("error", "Id was existed!");
                    request.getRequestDispatcher("../inputPage.jsp").forward(request, response);
                } else {
                    studentDao.createStudent(student);
                    response.sendRedirect(request.getContextPath() + "/student/list");
                }
            } catch (NumberFormatException | SQLException e) {
                response.sendRedirect(request.getContextPath() + "/student/list");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/student/list");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
