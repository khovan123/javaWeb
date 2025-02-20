package com.controller;

import com.entity.Article;
import com.model.ArticleModel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class DetailsPost extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArticleModel model;
        try {
            model = new ArticleModel();
            String id = request.getParameter("id"); // get id of post
            Article article = model.getDetailsPost(Integer.parseInt(id));
            request.setAttribute("content", article);
            request.setAttribute("urlCover", article);
            request.getRequestDispatcher("detailsPost.jsp").forward(request, response);
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
    }// </editor-fold>

}
