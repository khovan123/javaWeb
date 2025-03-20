package servlet;

import dao.CategoryDAOImpl;
import dao.MilkDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;
import model.Category;
import model.Milk;

@WebServlet(urlPatterns = {"/init", "/milk-add", "/milk-update", "/milk-delete", "/category-add","/milk-sort"})

public class MilkManagementServlet extends HttpServlet {

    private MilkDAOImpl milkDAO = new MilkDAOImpl();
    private CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        if (uri.endsWith("/milk-delete")) {
            try {
                int milkId = Integer.parseInt(request.getParameter("milkId"));
                milkDAO.deleteMilk(milkId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.endsWith("/milk-sort")) {
            String sortOrder = request.getParameter("order");
            List<Milk> milks = (List<Milk>) session.getAttribute("milks");
            if (milks != null) {
                if ("asc".equals(sortOrder)) {
                    Collections.sort(milks, Comparator.comparing(Milk::getName, String.CASE_INSENSITIVE_ORDER));
                } else if ("desc".equals(sortOrder)) {
                    Collections.sort(milks, (a, b) -> b.getName().compareToIgnoreCase(a.getName()));
                }
                session = request.getSession(true);
                session.setAttribute("milks", milks);
            }
        } else if (!uri.endsWith("/milk-sort")) {
            session.setAttribute("milks", milkDAO.getAllMilks());
        }
        session.setAttribute("categories", categoryDAO.getAllCategories());
        response.sendRedirect(request.getContextPath() + "/MilkManagement.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.endsWith("/milk-add")) {
            try {
                String milkName = request.getParameter("milkName");
                String categoryMilkId = request.getParameter("categoryMilkId");
                String milkPrice = request.getParameter("milkPrice");
                String milkOverview = request.getParameter("milkOverview");
                String milkOriginal = request.getParameter("milkOriginal");
                String milkHasSugar = request.getParameter("milkHasSugar");
                Milk milk = new Milk();
                milk.setName(milkName);
                milk.setUnit("piece");
                milk.setCategoryId(Integer.parseInt(categoryMilkId));
                milk.setPrice(Double.parseDouble(milkPrice));
                milk.setOverview(milkOverview);
                milk.setOriginal(milkOriginal);
                milk.setHasSugar(milkHasSugar.equalsIgnoreCase("1"));
                milkDAO.addMilk(milk);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.endsWith("/milk-update")) {
            try {
                String milkId = request.getParameter("milkId");
                String milkName = request.getParameter("milkName");
                String categoryMilkId = request.getParameter("categoryMilkId");
                String milkPrice = request.getParameter("milkPrice");
                String milkOverview = request.getParameter("milkOverview");
                String milkOriginal = request.getParameter("milkOriginal");
                String milkHasSugar = request.getParameter("milkHasSugar");
                Milk milk = new Milk();
                milk.setId(Integer.parseInt(milkId));
                milk.setName(milkName);
                milk.setUnit("piece");
                milk.setCategoryId(Integer.parseInt(categoryMilkId));
                milk.setPrice(Double.parseDouble(milkPrice));
                milk.setOverview(milkOverview);
                milk.setOriginal(milkOriginal);
                milk.setHasSugar(milkHasSugar.equalsIgnoreCase("1"));
                milkDAO.updateMilk(milk);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.endsWith("/milk-delete")) {
            try {
                String milkId = request.getParameter("milkId");
                milkDAO.deleteMilk(Integer.parseInt(milkId));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.endsWith("/category-add")) {
            try {
                String categoryName = request.getParameter("categoryName");
                String categoryDescription = request.getParameter("categoryDescription");
                Category category = new Category();
                category.setName(categoryName);
                category.setDescription(categoryDescription);
                categoryDAO.addCategory(category);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        doGet(request, response);
    }
}
