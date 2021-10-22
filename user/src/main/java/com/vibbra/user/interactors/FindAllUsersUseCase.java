package com.vibbra.user.interactors;

import com.vibbra.user.entities.User;
import com.vibbra.user.ports.UserPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllUsersUseCase {

    private final UserPort userPort;

    public FindAllUsersUseCase(UserPort userPort) {
        this.userPort = userPort;
    }

    public List<User> execute() {
        return userPort.getAllUsers();
    }
}
