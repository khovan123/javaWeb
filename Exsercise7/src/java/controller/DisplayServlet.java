package controller;

import CRUD.DAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import model.Student;

public class DisplayServlet extends HttpServlet {

    DAO markDAO = new DAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Exception e)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error Page</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Some thing went wrong: " + e.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Student> students = markDAO.getAll();
            request.setAttribute("students", students);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            processRequest(request, response, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
