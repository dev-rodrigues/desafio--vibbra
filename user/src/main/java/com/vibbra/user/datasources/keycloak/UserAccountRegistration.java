package com.vibbra.user.datasources.keycloak;

import com.google.gson.Gson;
import com.vibbra.user.datasources.feign.KeycloakFeign;
import com.vibbra.user.datasources.feign.data.*;
import com.vibbra.user.datasources.h2.repository.UserRepository;
import com.vibbra.user.entities.User;
import com.vibbra.user.ports.RegisterPort;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;

@Component
public class UserAccountRegistration implements RegisterPort {

    private final KeycloakFeign authenticateFeign;
    private final UserRepository userRepository;
    private final Gson gson;

    public UserAccountRegistration(KeycloakFeign authenticateFeign, UserRepository userRepository, Gson gson) {
        this.authenticateFeign = authenticateFeign;
        this.userRepository = userRepository;
        this.gson = gson;
    }

    @Override
    public void registerNewAccount(User user) {
        var map = new HashMap<String, Object>();
        map.put("zipCode", user.getLocation().getZipCode());
        map.put("userId", user.getId());
        var request = new CreateNewUserRequest(
                user.getId().toString(),
                user.getLogin(),
                user.getName(),
                user.getEmail(),
                Collections.singletonList(new Credentials(user.getPassword())),
                map);
        var requestAsString = gson.toJson(request);
        var token = getAdminToken().getAccessToken();
        authenticateFeign.createNewUser(KeycloakEnum.TOKEN_BEARER.value.concat(token), requestAsString);
    }

    @Override
    public void updateAccount(Long id, User user){
        var token = getAdminToken().getAccessToken();
        var oldUser = userRepository.getUserById(id);
        var result = authenticateFeign.getUserByEmail(KeycloakEnum.TOKEN_BEARER.value.concat(token), new QueyParamUserRequest(oldUser.getEmail()));
        var request = new UpdateUserRequest(
                user.getLogin(),
                user.getName(),
                user.getEmail(),
                Collections.singletonList(new Credentials(user.getPassword())));
        var requestAsString = gson.toJson(request);
        authenticateFeign.updateUser(KeycloakEnum.TOKEN_BEARER.value.concat(token), result.get(0).getId(), requestAsString);
    }

    private TokenResponse getAdminToken() {
        return authenticateFeign.authenticationRealmMaster(new TokenRequest(KeycloakEnum.ADMIN_USERNAME.value,
                                                                            KeycloakEnum.ADMIN_PASSWORD.value,
                                                                            KeycloakEnum.CLIENT_ID_ADMIN.value,
                                                                            KeycloakEnum.GRANT_TYPE.value));
    }

}
