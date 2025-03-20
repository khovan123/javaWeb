
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("1", "123");
        users.put("2", "123");
        users.put("3", "123");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        if (users.containsKey(userId) && users.get(userId).equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            response.sendRedirect("chat");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
