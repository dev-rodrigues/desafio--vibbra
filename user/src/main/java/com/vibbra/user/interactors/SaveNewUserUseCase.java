package com.vibbra.user.interactors;

import com.vibbra.user.datasources.h2.repository.UserRepository;
import com.vibbra.user.entities.User;
import org.springframework.stereotype.Service;

@Service
public class SaveNewUserUseCase {

    private final UserRepository userRepository;

    public SaveNewUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.saveNewUser(user);
    }
}
