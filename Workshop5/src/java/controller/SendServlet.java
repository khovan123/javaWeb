package controller;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Employee;

public class SendServlet extends HttpServlet {

    private ArrayList<Employee> employeeList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        employeeList.clear();
        employeeList.add(new Employee("Sakura", "Haruno", "Konoha", "Haruno", 1021));
        employeeList.add(new Employee("Itachi", "Uchiha", "Konoha", "Uchiha", 1021));
        employeeList.add(new Employee("Naruto", "Uzumaki", "Konoha", "Uzumaki", 1021));
        employeeList.add(new Employee("Kakashi", "Hatake", "Konoha", "Hatake", 1021));
        request.setAttribute("employees", employeeList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
