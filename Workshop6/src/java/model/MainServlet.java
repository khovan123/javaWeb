package model;

import CRUD.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet
public class MainServlet extends HttpServlet {

    private DAO personDAO = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pageSize = 5;
        ArrayList<Person> personList = new ArrayList<>();
        try {
            int page = Integer.parseInt((String) request.getParameter("page"));
            int quantity = personDAO.count();
            int maxIndex = quantity / pageSize;
            if (quantity % pageSize != 0) {
                maxIndex++;
            }            
            personList.addAll(personDAO.getAll(page, pageSize));
            request.setAttribute("records", personList);
            request.setAttribute("maxIndex", maxIndex);
            HttpSession session = request.getSession();
            session.setAttribute("active", page);
            request.getRequestDispatcher("../index.jsp").forward(request, response);
        } catch (NumberFormatException | SQLException e) {
            request.setAttribute("records", null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
