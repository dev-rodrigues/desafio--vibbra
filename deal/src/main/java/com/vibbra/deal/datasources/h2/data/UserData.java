package com.vibbra.deal.datasources.h2.data;

import com.vibbra.deal.datasources.h2.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserData extends CrudRepository<UserModel, Long> {

//    Optional<UserModel> findByLogin(String login);
}
