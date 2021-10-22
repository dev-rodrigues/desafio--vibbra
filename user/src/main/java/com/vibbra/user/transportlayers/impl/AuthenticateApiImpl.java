package com.vibbra.user.transportlayers.impl;

import com.vibbra.user.interactors.LoginUseCase;
import com.vibbra.user.transportLayers.openapi.api.AuthenticateApi;
import com.vibbra.user.transportLayers.openapi.model.RequestAuthenticate;
import com.vibbra.user.transportLayers.openapi.model.ResponseAuthenticate;
import com.vibbra.user.transportlayers.mapper.AuthenticationMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthenticateApiImpl implements AuthenticateApi {

    private final LoginUseCase loginUseCase;

    public AuthenticateApiImpl(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @Override
    public ResponseEntity<ResponseAuthenticate> authenticatePost(@RequestBody RequestAuthenticate requestAuthenticate) {
        var INSTANCE = Mappers.getMapper(AuthenticationMapper.class);
        var authenticationRequest = INSTANCE.map(requestAuthenticate);
        var authResponse = loginUseCase.authenticate(authenticationRequest);
        return ResponseEntity.status(HttpStatus.OK).body(INSTANCE.mapResponse(authResponse));
    }
}

