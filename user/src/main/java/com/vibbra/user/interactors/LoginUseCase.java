package com.vibbra.user.interactors;

import com.vibbra.user.datasources.keycloak.exceptions.UserOrPasswordDoesNotExists;
import com.vibbra.user.entities.request.AuthenticationRequest;
import com.vibbra.user.entities.response.AuthenticationResponse;
import com.vibbra.user.ports.AuthenticatePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(LoginUseCase.class);


    private final AuthenticatePort authenticatePort;

    public LoginUseCase(AuthenticatePort authenticatePort) {
        this.authenticatePort = authenticatePort;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws UserOrPasswordDoesNotExists {
        return authenticatePort.authenticate(authenticationRequest);
    }
}
