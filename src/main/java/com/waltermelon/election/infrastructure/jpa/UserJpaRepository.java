package com.waltermelon.election.infrastructure.jpa;

import com.waltermelon.election.infrastructure.enetity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
