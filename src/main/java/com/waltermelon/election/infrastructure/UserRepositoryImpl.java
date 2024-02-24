package com.waltermelon.election.infrastructure;

import com.waltermelon.election.domain.model.User;
import com.waltermelon.election.domain.repository.UserRepository;
import com.waltermelon.election.infrastructure.jpa.UserJpaRepository;
import com.waltermelon.election.infrastructure.mapper.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    public boolean save(User user) {
        userJpaRepository.save(UserEntityMapper.INSTANCE.UserToEntity(user));
        return Boolean.TRUE;
    }

    @Override
    public User getUser(Long id) {
        return UserEntityMapper.INSTANCE.UserEntityToUser(userJpaRepository.findById(id));
    }
}
