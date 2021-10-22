package com.vibbra.user.datasources.keycloak;

import com.vibbra.user.datasources.feign.KeycloakFeign;
import com.vibbra.user.datasources.feign.data.TokenRequest;
import com.vibbra.user.datasources.feign.data.TokenResponse;
import com.vibbra.user.datasources.h2.data.UserData;
import com.vibbra.user.datasources.h2.exceptions.UserNotFoundException;
import com.vibbra.user.datasources.h2.mapper.UserModelMapper;
import com.vibbra.user.datasources.keycloak.exceptions.UserOrPasswordDoesNotExists;
import com.vibbra.user.entities.request.AuthenticationRequest;
import com.vibbra.user.entities.response.AuthenticationResponse;
import com.vibbra.user.ports.AuthenticatePort;
import org.springframework.stereotype.Component;

@Component
public class KeycloakAuthenticate implements AuthenticatePort {

    private final KeycloakFeign authenticateFeign;
    private final UserData userData;

    public KeycloakAuthenticate(KeycloakFeign authenticateFeign, UserData userData) {
        this.authenticateFeign = authenticateFeign;
        this.userData = userData;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) throws UserOrPasswordDoesNotExists, UserNotFoundException {
            var getUserData = userData.findByLogin(request.getLogin()).orElseThrow(() -> new UserNotFoundException("User or password are incorrect"));
            if (getUserData.getPassword().equals(request.getPassword())) {
                var token = this.getToken(request);
                var mapper = UserModelMapper.INSTANCE;
                var user = mapper.map(getUserData);
                return new AuthenticationResponse(token.getAccessToken(), user);
            }
                throw new UserOrPasswordDoesNotExists("User or password are incorrect");

    }

    private TokenResponse getToken(AuthenticationRequest request) {
        return authenticateFeign.authentication(new TokenRequest(request.getLogin(), request.getPassword(), KeycloakEnum.CLIENT_ID_CLIENTES.value, KeycloakEnum.GRANT_TYPE.value));
    }
}
