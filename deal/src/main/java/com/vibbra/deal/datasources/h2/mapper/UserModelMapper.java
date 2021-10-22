package com.vibbra.deal.datasources.h2.mapper;

import com.vibbra.deal.datasources.h2.model.UserModel;
import com.vibbra.deal.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserModelMapper {

    UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    User map(UserModel userModel);
}
