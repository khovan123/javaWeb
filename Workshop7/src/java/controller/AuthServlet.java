package controller;

import CRUD.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import model.User;

@WebServlet(urlPatterns = {"/auth/servlet1", "/auth/servlet2"})
public class AuthServlet extends HttpServlet {

    DAO authDAO = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = authDAO.select(userName, password);
            if(user!=null){
            }
            HttpSession session = request.getSession();
            session.setAttribute("login", true);            
            response.sendRedirect("../index.jsp");
        } catch (SQLException e) {
            response.sendRedirect("login.jsp?error=Authenticate+failed");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
