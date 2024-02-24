package com.waltermelon.election.domain.repository;

import com.waltermelon.election.domain.model.User;

public interface UserRepository {
    User getUser(Long id);

    boolean save(User user);
}
