package com.vibbra.user.transportlayers.mapper;

import com.vibbra.user.transportLayers.openapi.model.Invite;
import com.vibbra.user.transportLayers.openapi.model.RequestNewInvite;
import com.vibbra.user.transportLayers.openapi.model.ResponseNewInvite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InviteMapper {

    InviteMapper INSTANCE = Mappers.getMapper(InviteMapper.class);

    com.vibbra.user.entities.Invite map(RequestNewInvite request);

    Invite map(com.vibbra.user.entities.Invite invite);


    ResponseNewInvite mapResponse(com.vibbra.user.entities.Invite invite);


}
