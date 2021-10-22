package com.vibbra.user.transportlayers.impl;

import com.vibbra.user.interactors.*;
import com.vibbra.user.transportLayers.openapi.api.UsersApi;
import com.vibbra.user.transportLayers.openapi.model.*;
import com.vibbra.user.transportlayers.mapper.InviteMapper;
import com.vibbra.user.transportlayers.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class UsersApiImpl implements UsersApi {

    private final RegisterNewUserAccountUseCase registerNewUserAccountUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final SaveNewUserUseCase saveNewUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final ListInvitesUseCase listInvitesUseCase;
    private final InviteUserUseCase inviteUserUseCase;
    private final UserMapper mapper;
    private final InviteMapper inviteMapper;
    private final FindAllUsersUseCase findAllUsersUseCase;

    public UsersApiImpl(RegisterNewUserAccountUseCase registerNewUserAccountUseCase, GetUserByIdUseCase getUserByIdUseCase, SaveNewUserUseCase saveNewUserUseCase, UpdateUserUseCase updateUserUseCase, ListInvitesUseCase listInvitesUseCase, InviteUserUseCase inviteUserUseCase, FindAllUsersUseCase findAllUsersUseCase) {
        this.registerNewUserAccountUseCase = registerNewUserAccountUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.saveNewUserUseCase = saveNewUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.listInvitesUseCase = listInvitesUseCase;
        this.inviteUserUseCase = inviteUserUseCase;
        this.findAllUsersUseCase = findAllUsersUseCase;
        this.mapper = UserMapper.INSTANCE;
        this.inviteMapper = InviteMapper.INSTANCE;
    }

    @Override
    public ResponseEntity<ResponseNewUser> createUser(@RequestBody RequestNewUser requestNewUser) {
        var user = mapper.map(requestNewUser);
        var salvedUser = saveNewUserUseCase.save(user);
        registerNewUserAccountUseCase.createNewUser(salvedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(salvedUser));
    }

    @Override
    public ResponseEntity<ResponseGetUserById> getUserById(@PathVariable("id") Long id) {
        var user = getUserByIdUseCase.getUserById(id);
        var responseUser = mapper.mapGetById(user);
        return ResponseEntity.status(HttpStatus.OK).body(responseUser);
    }

    @Override
    public ResponseEntity<ResponseUpdateUser> updateUser(@PathVariable("id") Long id, @RequestBody RequestUpdateUser requestUpdateUser) {
        var user = mapper.map(requestUpdateUser);
        var response = mapper.mapUpdateUser(updateUserUseCase.updateUser(id, user));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<List<Invite>> getInvites(@PathVariable("id") Long id) {
        var invites = listInvitesUseCase.executar(id);
        return ResponseEntity.status(HttpStatus.OK).body(invites.stream().map(inviteMapper::map).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<ResponseNewInvite> usersIdInvitesPost(@PathVariable("id") Long id, @RequestBody RequestNewInvite requestNewInvite) {
        var invite = inviteUserUseCase.inviteUser(inviteMapper.map(requestNewInvite));
        return ResponseEntity.status(HttpStatus.CREATED).body(inviteMapper.mapResponse(invite));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        var response = findAllUsersUseCase.execute();
        return ResponseEntity.ok(response);
    }

}
