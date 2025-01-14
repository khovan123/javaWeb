package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;
import model.Student;

public class StudentServlet extends HttpServlet {

    private ArrayList<Student> studentList = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private boolean isExited(int id) {
        return search(p -> p.getId() == id) != null;
    }

    private Student search(Predicate<Student> p) {
        for (Student student : studentList) {
            if (p.test(student)) {
                return student;
            }
        }
        return null;
    }

    private String createRowTable(Student student) {
        return "<tr><td><span>" + student.getId() + "</span></td><td><span>" + student.getName() + "</span></td><td><span><input type=\"checkbox\"" + (student.isGender() ? "checked" : "") + "/></span></td>" + "<td><span>" + sdf.format(student.getDob()) + "</span></td></tr>";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentServlet</title>");
            out.println("<style>");
            out.println("table { table-layout: auto; }");
            out.println("span { display: inline-block;width: 100%; display: flex; height: 20px; align-items: center;}");
            out.println("input { margin: 0px;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='1'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th><span>ID</span></th>");
            out.println("<th><span>Name</span></th>");
            out.println("<th><span>Gender</span></th>");
            out.println("<th><span>DoB</span></th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            studentList.forEach(student -> {
                out.print(createRowTable(student));
            });
            out.println("</tbody>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd");
            int id = Integer.parseInt((String) request.getParameter("id"));
            String name = (String) request.getParameter("name");
            Date dob = _sdf.parse((String) request.getParameter("dob"));
            boolean gender = request.getParameter("gender").equals("male");
            while (isExited(id)) {
                id++;
            }
            studentList.add(new Student(id, name, gender, dob));
        } catch (NumberFormatException | ParseException e) {

        }
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
