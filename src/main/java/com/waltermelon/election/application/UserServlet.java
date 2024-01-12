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
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3001");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");


        String id = request.getParameter("id");
        System.out.println(String.format("There is a request, request userId: %s", id));
        PrintWriter out = response.getWriter();
        try {
            User user = userController.getUsers(Integer.valueOf(id));
            if (user != null) {
                getServletContext().log("This is a custom log message");
                response.setStatus(HttpServletResponse.SC_OK);
                out.write(user.toJson());
            } else {
                getServletContext().log("No matching data in repository.");
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            getServletContext().log("meet a exception when access repository");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.getStackTrace();
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        try {
            boolean isSucceeded = userController.createUser(id, username, email);
            if (isSucceeded) {
                System.out.println("successfully get data from repository!");
                response.setStatus(HttpServletResponse.SC_CREATED);
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        response.getWriter().println("you are posting info to Servlet");
    }
}
