package com.vibbra.user.datasources.h2.mapper;

import com.vibbra.user.datasources.h2.model.InviteModel;
import com.vibbra.user.entities.Invite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InviteModelMapper {

    InviteModelMapper INSTANCE = Mappers.getMapper(InviteModelMapper.class);

    Invite map(InviteModel inviteModel);

    InviteModel map(Invite invite);


}
