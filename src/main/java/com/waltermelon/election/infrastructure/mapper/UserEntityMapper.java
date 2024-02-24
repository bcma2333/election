package com.waltermelon.election.infrastructure.mapper;

import com.waltermelon.election.domain.model.User;
import com.waltermelon.election.infrastructure.enetity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapper {
    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    User UserEntityToUser(UserEntity userEntity);

    UserEntity UserToEntity(User user);
}
