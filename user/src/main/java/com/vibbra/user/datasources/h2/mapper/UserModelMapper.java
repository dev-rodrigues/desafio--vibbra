package com.vibbra.user.datasources.h2.mapper;

import com.vibbra.user.datasources.h2.model.UserModel;
import com.vibbra.user.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserModelMapper {

    UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    User map(UserModel userModel);

    UserModel map(User user);
}
