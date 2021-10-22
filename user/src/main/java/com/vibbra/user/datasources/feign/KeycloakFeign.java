package com.vibbra.user.datasources.feign;

import com.vibbra.user.configs.FeignConfiguration;
import com.vibbra.user.datasources.feign.data.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "authenticate", url ="${authenticate.host}", configuration = FeignConfiguration.class)
public interface KeycloakFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/realms/clientes/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenResponse authentication(@RequestBody TokenRequest tokenRequest);

    @RequestMapping(method = RequestMethod.POST, value = "/realms/master/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenResponse authenticationRealmMaster(@RequestBody TokenRequest tokenRequest);

    @RequestMapping(method = RequestMethod.POST, value = "/admin/realms/clientes/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createNewUser(@RequestHeader("Authorization") String token, @RequestBody String createNewUserRequest);

    @RequestMapping(method = RequestMethod.PUT, value = "/admin/realms/clientes/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateUser(@RequestHeader("Authorization") String token, @PathVariable("id") String id, @RequestBody String updateUserRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/admin/realms/clientes/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<UserRepresentation> getUserByEmail(@RequestHeader("Authorization") String token, @SpringQueryMap QueyParamUserRequest queyParamUserRequest);
}
