package controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        if (user.equals(getServletConfig().getInitParameter("user"))
                && password.equals(getInitParameter("password"))) {
//            request.getRequestDispatcher("WelcomeServlet").forward(request, response);
            response.sendRedirect("WelcomeServlet");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
