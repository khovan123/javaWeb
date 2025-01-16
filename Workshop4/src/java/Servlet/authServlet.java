package Servlet;

import CRUD.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

public class authServlet extends HttpServlet {

    private DAO authDAO = new DAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        try {
            String displayName = authDAO.select(userName, password);
            HttpSession session = request.getSession();            
            session.setAttribute("displayName", displayName);
            if (remember != null) {
                Cookie loginCookie = new Cookie("login", "true");
                Cookie dataCookie = new Cookie("displayName", displayName);
                loginCookie.setMaxAge(30 * 60);
                dataCookie.setMaxAge(30 * 60);
                response.addCookie(loginCookie);
                response.addCookie(dataCookie);
            }
            response.sendRedirect("detail.jsp");
        } catch (SQLException e) {
            response.sendRedirect("login.jsp?error=Authenticate+failed");
        }
    }

}
