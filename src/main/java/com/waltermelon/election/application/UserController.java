package com.waltermelon.election.application;

import com.waltermelon.election.domain.User;
import com.waltermelon.election.repository.UserRepository;

public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUsers(Integer id) {
        return userRepository.getUser(id);
    }

    public boolean createUser(String id, String username, String email) {
        User user = new User(Integer.parseInt(id), username, email);
        return userRepository.save(user);
    }

    public static void main(String[] args) {
        UserController userController = new UserController(new UserRepository());
        User user = userController.getUsers(1);
        System.out.println(user.toJson());
    }

}
