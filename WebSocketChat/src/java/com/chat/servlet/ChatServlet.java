package com.chat.servlet;

import com.chat.model.User;
import jakarta.servlet.*;
import java.io.IOException;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = (String) request.getSession().getAttribute("userId");

        try {
            List<User> friends_1 = new ArrayList<>();
            List<User> friends_2 = new ArrayList<>();

            if (userId.equals("1")) {
                friends_1.add(new User("2", "Minh"));
                friends_1.add(new User("3", "Nhi"));
                friends_1.add(new User("4", "Kang"));
                friends_1.add(new User("5", "Huy"));
                request.setAttribute("friends", friends_1);

            } else if (userId.equals("2")) {
                friends_2.add(new User("1", "Hana"));
                friends_2.add(new User("3", "Nhi"));
                friends_2.add(new User("4", "Kang"));
                friends_2.add(new User("5", "Huy"));
                request.setAttribute("friends", friends_2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/chat.jsp").forward(request, response);
    }
}
