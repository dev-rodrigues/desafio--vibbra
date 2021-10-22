package com.vibbra.deal.ports;

import com.vibbra.deal.entities.request.AuthenticationRequest;
import com.vibbra.deal.entities.response.AuthenticationResponse;

public interface AuthenticatePort {

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
