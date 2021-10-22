package com.vibbra.user.datasources.h2.repository;

import com.vibbra.user.datasources.h2.data.InviteData;
import com.vibbra.user.datasources.h2.data.UserData;
import com.vibbra.user.datasources.h2.exceptions.UserNotFoundException;
import com.vibbra.user.datasources.h2.mapper.InviteModelMapper;
import com.vibbra.user.entities.Invite;
import com.vibbra.user.ports.InvitePort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InviteRepository implements InvitePort {

    private final InviteData inviteData;
    private final UserData userData;

    public InviteRepository(InviteData inviteData, UserData userData) {
        this.inviteData = inviteData;
        this.userData = userData;
    }

    @Override
    public Invite inviteUser(Invite invite) {
        var mapper = InviteModelMapper.INSTANCE;
        var inviteModel  = mapper.map(invite);
        userData.findById(inviteModel.getUser()).orElseThrow(() -> new UserNotFoundException("User not found"));
        userData.findById(inviteModel.getUserInvited()).orElseThrow(() -> new UserNotFoundException("User invited not found"));
        return mapper.map(inviteData.save(inviteModel));
    }

    @Override
    public List<Invite> getInvites(Long id) {
        var mapper = InviteModelMapper.INSTANCE;
        var invites = inviteData.findByUser(id);
        return invites.stream().map(mapper::map).collect(Collectors.toList());
    }
}
