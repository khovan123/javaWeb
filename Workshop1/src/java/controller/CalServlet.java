package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/CalServlet"})
public class CalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("caculatorPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int first = Integer.parseInt(request.getParameter("first"));
            int second = Integer.parseInt(request.getParameter("second"));
            String operator = request.getParameter("operator");
            int result = 0;
            double dbResult = 0;
            request.setAttribute("first", first);
            request.setAttribute("second", second);
            request.setAttribute("operator", operator);
            switch (operator) {
                case "+" ->
                    result = first + second;
                case "-" ->
                    result = first - second;
                case "*" ->
                    result = first * second;
                case "/" -> {
                    if (second != 0) {
                        dbResult = (double) first / (double) second;
                    } else {
                        request.setAttribute("result", "Cannot divide by zero");
                        request.getRequestDispatcher("caculatorPage.jsp").forward(request, response);
                        return;
                    }
                }
            }
            if (operator.equals("/")) {
                request.setAttribute("result", dbResult);
            } else {
                request.setAttribute("result", result);
            }
        } catch (NumberFormatException e) {
        }
        request.getRequestDispatcher("caculatorPage.jsp").forward(request, response);
    }
}
