package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/CalServlet"})
public class CalServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"CalServlet\" style=\"width:fit-content; display: grid; grid-template-columns: auto 1fr; gap: 10px;\" method=\"POST\">");

            String first = (String) request.getAttribute("first");
            out.print("<label for=\"first\" style=\"display: block;\">First:</label>");
            out.print("<input name=\"first\" id=\"first\" type=\"number\" " + (first != null ? "value=\"" + first + "\"" : "") + " required/>");

            String second = (String) request.getAttribute("second");
            out.print("<label for=\"second\" style=\"display: block;\">Second:</label>");
            out.print("<input name=\"second\" id=\"second\" type=\"number\" " + (second != null ? "value=\"" + second + "\"" : "") + " required/>");

            String operator = (String) request.getAttribute("operator");
            out.print("<label for=\"operator\" style=\"display: block;\">Operator:</label>");
            out.print("<select name=\"operator\" id=\"operator\" style=\"width:fit-content;\" required>");
            out.print("<option value=\"+\" " + ("+".equals(operator) ? "selected" : "") + ">+</option>");
            out.print("<option value=\"-\" " + ("-".equals(operator) ? "selected" : "") + ">-</option>");
            out.print("<option value=\"*\" " + ("*".equals(operator) ? "selected" : "") + ">*</option>");
            out.print("<option value=\"/\" " + ("/".equals(operator) ? "selected" : "") + ">/</option>");
            out.print("</select>");

            out.print("<button style=\"grid-column:2/3;grid-row:4/5;width:fit-content\" type=\"submit\">Compute</button>");

            String result = (String) request.getAttribute("result");
            out.print("<label for=\"result\" style=\"display:block;grid-row:5/6\">Result:</label>");
            out.print("<input id=\"result\" name=\"result\" value=\"" + (result != null ? result : "") + "\" style=\"width:100%;grid-row:5/6;\" disabled/>");

            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int first = Integer.parseInt(request.getParameter("first"));
            int second = Integer.parseInt(request.getParameter("second"));
            String operator = request.getParameter("operator");
            int result = 0;
            switch (operator) {
                case "+" ->
                    result = first + second;
                case "-" ->
                    result = first - second;
                case "*" ->
                    result = first * second;
                case "/" -> {
                    if (second != 0) {
                        result = first / second;
                    } else {
                        request.setAttribute("result", "Cannot divide by zero");
                        processRequest(request, response);
                        return;
                    }
                }
            }
            request.setAttribute("first", String.valueOf(first));
            request.setAttribute("second", String.valueOf(second));
            request.setAttribute("operator", String.valueOf(operator));
            request.setAttribute("result", String.valueOf(result));
        } catch (NumberFormatException e) {
        }

        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
