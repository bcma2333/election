package com.waltermelon.election.infrastructure;

import com.waltermelon.election.domain.model.User;
import com.waltermelon.election.domain.repository.UserRepository;
import com.waltermelon.election.infrastructure.enetity.UserEntity;
import com.waltermelon.election.infrastructure.jpa.UserJpaRepository;
import com.waltermelon.election.infrastructure.mapper.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    public boolean save(User user) {
        userJpaRepository.save(UserEntityMapper.INSTANCE.UserToEntity(user));
        return Boolean.TRUE;
    }

    @Override
    public User getUser(Long id) {
        Optional<UserEntity> userEntity = Optional.of(userJpaRepository.findById(id).orElseThrow());
        return UserEntityMapper.INSTANCE.UserEntityToUser(userEntity.get());
    }
}
