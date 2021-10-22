package com.vibbra.user.interactors;

import com.vibbra.user.entities.User;
import com.vibbra.user.ports.RegisterPort;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewUserAccountUseCase {

    private final RegisterPort authPort;

    public RegisterNewUserAccountUseCase(RegisterPort authPort) {
        this.authPort = authPort;
    }

    public void createNewUser(User user) {
        authPort.registerNewAccount(user);
    }

}
