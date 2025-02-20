package com.controller;

import com.entity.Information;
import com.model.ArticleModel;
import com.model.InfoModel;
import com.model.ViewModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ArticleModel model = new ArticleModel();
            InfoModel infoModel = new InfoModel();
            List<Information> info = infoModel.getInfoPage();
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

            if (page > totalPage) {
                request.setAttribute("noContent", "No article here!");
            } else {
                request.setAttribute("content", model.getArticlesFromTo(page, pageSize));
            }
            ViewModel viewModel = new ViewModel();
            HttpSession session = request.getSession();
            if (session.isNew()) {
                viewModel.updateView();
            }
            
            int view = viewModel.getView();
            String formatted = String.format("%05d", view);
            request.setAttribute("view", formatted);
            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("urlCover", infoModel.getUrlCover(info));
            request.setAttribute("active", "HomeColor");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("error.jsp");
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
