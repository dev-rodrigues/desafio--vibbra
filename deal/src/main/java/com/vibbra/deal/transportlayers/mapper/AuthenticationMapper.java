package com.vibbra.deal.transportlayers.mapper;

import com.vibbra.deal.entities.request.AuthenticationRequest;
import com.vibbra.deal.entities.response.AuthenticationResponse;
import com.vibbra.deal.transportLayers.openapi.model.RequestAuthenticate;
import com.vibbra.deal.transportLayers.openapi.model.ResponseAuthenticate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthenticationMapper {


    AuthenticationMapper INSTANCE = Mappers.getMapper(AuthenticationMapper.class);


    AuthenticationRequest map(RequestAuthenticate requestAuthenticate);

    ResponseAuthenticate mapResponse(AuthenticationResponse request);
}
