package com.waltermelon.election.application;

import com.waltermelon.election.domain.UserService;
import com.waltermelon.election.domain.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUsers(@PathVariable(value = "id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public boolean createUser(Long id, String username, String email) {
        User user = new User(id, username, email);
        return userService.save(user);
    }
}
