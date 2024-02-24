package com.waltermelon.election.domain;

import com.waltermelon.election.domain.model.User;
import com.waltermelon.election.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.getUser(id);
    }

    public boolean save(User user) {
        return userRepository.save(user);
    }
}
