package com.waltermelon.election.application;

import com.waltermelon.election.domain.User;
import com.waltermelon.election.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserControllerTest {
    private UserController userController;
    private UserRepository userRepository = mock(UserRepository.class);

    @BeforeEach
    void setUp() {
        userController = new UserController(userRepository);
    }

    @Test
    void should_list_user() {
        // Given
        User user = new User(1, "walter", "walter@thoughtwors.com");
        when(userRepository.getUser()).thenReturn(user);
        // When
        User result = userController.getUsers();
        // Then
        Assertions.assertEquals(user.getId(), result.getId());
        Assertions.assertEquals(user.getUsername(), result.getUsername());
        Assertions.assertEquals(user.getEmail(), result.getEmail());
    }
}