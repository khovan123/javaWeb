package controller;


import CRUD.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import model.Student;

@WebServlet(urlPatterns = {"/student/list", "/student/delete"})
public class StudentListServlet extends HttpServlet {

    private static DAO studentDao = new DAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("studentList");
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("../studentTable.jsp").forward(request, response);
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
                } catch (NumberFormatException | SQLException e) {
                    processError(request, response, e);
                }
            }
        } else {
            try {
                ArrayList<Student> studentList = new ArrayList<>(studentDao.getAllStudents());
                request.setAttribute("studentList", studentList);
                processRequest(request, response);
            } catch (SQLException e) {
                processError(request, response, e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
