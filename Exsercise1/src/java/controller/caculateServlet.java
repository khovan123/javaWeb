package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/caculateServlet"})
public class caculateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String shape = request.getParameter("shape");
        double result = 0;
        String cal = request.getParameter("cal");
        if (cal.toUpperCase().equalsIgnoreCase("S")) {
            try {
                switch (shape) {
                    case "rectangle" -> {
                        double length = Double.parseDouble(request.getParameter("length"));
                        double width = Double.parseDouble(request.getParameter("width"));
                        if (length <= 0 || width <= 0) {
                            request.setAttribute("result", "Invalid Value!");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            return;
                        }
                        result = length * width;
                    }
                    case "triangle" -> {
                        double a = Double.parseDouble(request.getParameter("edgeA"));
                        double b = Double.parseDouble(request.getParameter("edgeB"));
                        double c = Double.parseDouble(request.getParameter("edgeC"));
                        if (a <= 0 || b <= 0 || c <= 0) {
                            request.setAttribute("result", "Invalid Value!");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            return;
                        } else if (a + b > c && b + c > a && a + c > b) {
                            double s = (a + b + c) / 2;
                            result = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                        } else {
                            request.setAttribute("result", "Not a triangle");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            return;
                        }
                    }
                    case "circle" -> {
                        double radius = Double.parseDouble(request.getParameter("radius"));
                        if (radius <= 0) {
                            request.setAttribute("result", "Invalid Value!");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            return;
                        }
                        result = Math.PI * Math.pow(radius, 2);
                    }
                }
            } catch (NumberFormatException e) {
                request.setAttribute("result", null);
            }
        } else if (cal.toUpperCase().equalsIgnoreCase("P")) {
            try {
                switch (shape) {
                    case "rectangle" -> {
                        double length = Double.parseDouble(request.getParameter("length"));
                        double width = Double.parseDouble(request.getParameter("width"));
                        if (length <= 0 || width <= 0) {
                            request.setAttribute("result", "Invalid Value!");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            return;
                        }
                        result = (length + width) * 2;
                    }
                    case "triangle" -> {
                        double a = Double.parseDouble(request.getParameter("edgeA"));
                        double b = Double.parseDouble(request.getParameter("edgeB"));
                        double c = Double.parseDouble(request.getParameter("edgeC"));
                        if (a <= 0 || b <= 0 || c <= 0) {
                            request.setAttribute("result", "Invalid Value!");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            return;
                        } else if (a + b > c && b + c > a && a + c > b) {
                            result = a + b + c;
                        } else {
                            request.setAttribute("result", "Not a triangle");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            return;
                        }
                    }
                    case "circle" -> {
                        double radius = Double.parseDouble(request.getParameter("radius"));
                        if (radius <= 0) {
                            request.setAttribute("result", "Invalid Value!");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            return;
                        }
                        result = Math.PI * 2 * radius;
                    }
                }
            } catch (NumberFormatException e) {
                request.setAttribute("result", null);
            }
        } else {
            request.setAttribute("result", null);
        }
        request.setAttribute("result", String.valueOf(result));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
