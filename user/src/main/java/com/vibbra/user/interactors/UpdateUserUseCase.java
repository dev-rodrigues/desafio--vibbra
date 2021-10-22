package com.vibbra.user.interactors;

import com.vibbra.user.entities.User;
import com.vibbra.user.ports.RegisterPort;
import com.vibbra.user.ports.UserPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase {

    private final UserPort userPort;
    private final RegisterPort registerPort;

    public UpdateUserUseCase(UserPort userPort, RegisterPort registerPort) {
        this.userPort = userPort;
        this.registerPort = registerPort;
    }

    public User updateUser(Long id, User user) {
        var oldUser = userPort.getUserById(id);
        var updatedUser = updateField(oldUser, user);
        registerPort.updateAccount(id, updatedUser);
        return userPort.updateUser(id, updatedUser);
    }

    private User updateField(User oldUser, User newUser) {
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setLocation(newUser.getLocation());
        oldUser.setLogin(newUser.getLogin());
        oldUser.setPassword(newUser.getPassword());
        return oldUser;
    }
}
