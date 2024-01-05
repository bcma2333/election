package com.waltermelon.election.application;

import com.waltermelon.election.domain.User;
import com.waltermelon.election.repository.UserRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {

    private final UserController userController;

    public UserServlet() {
        this.userController = new UserController(new UserRepository());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        System.out.println(request.getPathTranslated());
        PrintWriter out = response.getWriter();
        User user = userController.getUsers();
        if (user != null) {
            out.write(user.toJson());
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        try {
            userController.createUser(id, username, email);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            e.getStackTrace();
        }
        response.getWriter().println("you are posting info to Servlet");

    }
}
