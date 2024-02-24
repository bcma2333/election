package com.waltermelon.election.domain;

import com.waltermelon.election.domain.model.User;
import com.waltermelon.election.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.getUser(id);
    }

    public boolean save(User user) {
        return userRepository.save(user);
    }
}
