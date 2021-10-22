package com.vibbra.user.transportlayers.mapper;

import com.vibbra.user.entities.request.AuthenticationRequest;
import com.vibbra.user.entities.response.AuthenticationResponse;
import com.vibbra.user.transportLayers.openapi.model.RequestAuthenticate;
import com.vibbra.user.transportLayers.openapi.model.ResponseAuthenticate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthenticationMapper {

    AuthenticationMapper INSTANCE = Mappers.getMapper(AuthenticationMapper.class);

    AuthenticationRequest map(RequestAuthenticate requestAuthenticate);

    ResponseAuthenticate mapResponse(AuthenticationResponse request);
}
