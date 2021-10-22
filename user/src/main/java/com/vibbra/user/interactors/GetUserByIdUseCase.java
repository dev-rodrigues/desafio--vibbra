package com.vibbra.user.interactors;

import com.vibbra.user.entities.User;
import com.vibbra.user.ports.UserPort;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdUseCase {

    private final UserPort userPort;

    public GetUserByIdUseCase(UserPort userPort) {
        this.userPort = userPort;
    }

    public User getUserById(Long id) {
        try {
            return userPort.getUserById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
