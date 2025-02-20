package com.controller;
import com.model.MenuModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class MenuController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            MenuModel model = new MenuModel();
            int page = 1, pageSize = 2;
            int totalPage = model.getTotalRows();
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            if (totalPage % pageSize == 0) {
                totalPage = totalPage / pageSize;
            } else {
                totalPage = totalPage / pageSize + 1;
            }
            
            if(page > totalPage){
                request.setAttribute("noContent", "No menu here!");
            }else{
                request.setAttribute("menus", model.getMenusFromTo(page, pageSize));
            }          
            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("active", "MenuColor");     
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("error.jsp");
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
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
