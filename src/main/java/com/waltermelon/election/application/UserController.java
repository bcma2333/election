package com.waltermelon.election.application;

import com.waltermelon.election.domain.User;
import com.waltermelon.election.repository.UserRepository;

public class UserController {
    private final UserRepository userRepository;

    public UserController() {
        this.userRepository = new UserRepository();
    }

    public User getUsers() {
        return userRepository.getUser();
    }

    public static void main(String[] args) {
        User users = new UserController().getUsers();
        System.out.println(users.toJson());
    }
}
