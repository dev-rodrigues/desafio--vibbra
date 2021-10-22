package com.vibbra.user.datasources.h2.repository;

import com.vibbra.user.datasources.h2.data.UserData;
import com.vibbra.user.datasources.h2.exceptions.UserNotFoundException;
import com.vibbra.user.datasources.h2.mapper.UserModelMapper;
import com.vibbra.user.datasources.h2.model.UserModel;
import com.vibbra.user.entities.User;
import com.vibbra.user.ports.UserPort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements UserPort {

    private final UserData userData;

    public UserRepository(UserData userData) {
        this.userData = userData;
    }

    @Override
    public User saveNewUser(User user) {
        var INSTANCE = Mappers.getMapper(UserModelMapper.class);
        var userModel = INSTANCE.map(user);
        return INSTANCE.map(userData.save(userModel));
    }

    @Override
    public User getUserById(Long id) {
        var INSTANCE = Mappers.getMapper(UserModelMapper.class);
        var userModel = userData.findById(id).orElseThrow(() -> new UserNotFoundException("User not find"));
        return INSTANCE.map(userModel);
    }

    @Override
    public User updateUser(Long id, User user) {
        var INSTANCE = Mappers.getMapper(UserModelMapper.class);
        getUserById(id);
        return INSTANCE.map(userData.save(INSTANCE.map(user)));
    }

    @Override
    public List<User> getAllUsers() {
        var INSTANCE = Mappers.getMapper(UserModelMapper.class);
        var response = (List<UserModel>) userData.findAll();
        return response.stream().map(INSTANCE::map).collect(Collectors.toList());
    }


}
