package com.vibbra.user.ports;

import com.vibbra.user.datasources.keycloak.exceptions.UserOrPasswordDoesNotExists;
import com.vibbra.user.entities.request.AuthenticationRequest;
import com.vibbra.user.entities.response.AuthenticationResponse;

public interface AuthenticatePort {

    AuthenticationResponse authenticate(AuthenticationRequest request) throws UserOrPasswordDoesNotExists;
}
