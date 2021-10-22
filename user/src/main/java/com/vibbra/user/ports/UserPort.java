package com.vibbra.user.ports;

import com.vibbra.user.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserPort {

    User saveNewUser(User user);

    User getUserById(Long id);

    User updateUser(Long id, User user);

    List<User> getAllUsers();
}
