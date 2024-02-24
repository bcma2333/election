package com.waltermelon.election.application;

import com.waltermelon.election.domain.UserService;
import com.waltermelon.election.domain.model.User;
import com.waltermelon.election.domain.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserControllerTest {
    private UserController userController;
    private UserService userService = mock(UserService.class);
    private UserRepository userRepository = mock(UserRepository.class);

    @BeforeEach
    void setUp() {
        userController = new UserController(userService);
    }

    @Test
    void should_list_user() {
        // Given
        User user = new User(1L, "walter", "walter@thoughtwors.com");
        when(userService.getUser(1L)).thenReturn(user);
        // When
        User result = userController.getUsers(1L);
        // Then
        Assertions.assertEquals(user.getId(), result.getId());
        Assertions.assertEquals(user.getUsername(), result.getUsername());
        Assertions.assertEquals(user.getEmail(), result.getEmail());
    }

    @Test
    void should_create_user() {
        // Given
        Long id = 2L;
        String username = "johnson";
        String email = "johnson@163.com";
        // When
        userController.createUser(id, username, email);
        // Then
        verify(userRepository, times(1)).save(any());
    }
}