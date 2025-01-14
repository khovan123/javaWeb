
import CRUD.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/student/create", "/student/update"})

public class StudentCreateServlet extends HttpServlet {

    private static DAO studentDao = new DAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String error = (String) request.getParameter("error");
        String _id = (String) request.getParameter("id");
        String id = null;
        String name = null;
        String gender = null;
        String dob = null;
        if (_id != null && !_id.isEmpty()) {
            try {
                String res = studentDao.getStudentById(Integer.parseInt(_id));
                if (res != null) {
                    String data[] = res.split(",");
                    id = data[0];
                    name = data[1];
                    gender = data[2];
                    dob = data[3];
                }
            } catch (NumberFormatException | SQLException e) {
                error = e.getMessage();
                _id = null;
            }
        }
        try (PrintWriter out = response.getWriter()) {
            if (id != null && !id.isEmpty() && error != null && !error.isEmpty()) {
                out.println("<p style='color:red;'>" + error + "</p>");
                out.println("<a href='../student/list'>Update</button>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet StudentCreateServlet</title>");
                out.println("</head>");
                out.println("<body>");
                if (id != null && !id.isEmpty()) {
                    out.println("<form action='../student/updateList' method='post'>");
                    out.println("<input type='hidden' name='oldId' value='" + (_id != null ? _id : "") + "'>");
                } else {
                    out.println("<form action='../student/list' method='post'>");
                }
                out.println("Id: <input type='number' name='id' id='id' value='" + (id != null ? id : "") + "' required><br><br>");
                out.println("Name: <input type='text' name='name' id='name' value='" + (name != null ? name : "") + "' required><br><br>");
                out.println("Gender: ");
                out.println("<input type='radio' name='gender' id='male' value='male'" + (gender != null && gender.equals("1") ? " checked " : "") + "required> Male ");
                out.println("<input type='radio' name='gender' id='female' value='female'" + (gender != null && gender.equals("0") ? " checked " : "") + "required> Female<br><br>");
                out.println("DOB: <input type='date' name='dob' id='dob' value='" + (dob != null ? dob : "") + "' required><br><br>");
                if (id != null && !id.isEmpty()) {
                    out.println("<button type='summit'>Update</button>");
                } else {
                    out.println("<button type='summit'>Create</button>");
                }
                if (error != null && !error.isEmpty()) {
                    out.println("<p style='color:red;'>" + error + "</p>");
                }
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
