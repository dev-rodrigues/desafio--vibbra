package com.vibbra.user.ports;

import com.vibbra.user.entities.User;

public interface RegisterPort {

    void registerNewAccount(User user);

    void updateAccount(Long id, User user);
}
