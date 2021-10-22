package com.vibbra.user.transportlayers.mapper;

import com.vibbra.user.entities.User;
import com.vibbra.user.transportLayers.openapi.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User map(RequestNewUser request);

    ResponseNewUser map(User user);

    ResponseGetUserById mapGetById(User user);

    ResponseUpdateUser mapUpdateUser(User user);

    User map(RequestUpdateUser requestUpdateUser);
}
