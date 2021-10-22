package com.vibbra.user.ports;

import com.vibbra.user.datasources.h2.exceptions.UserNotFoundException;
import com.vibbra.user.entities.Invite;

import java.util.List;

public interface InvitePort {

    Invite inviteUser(Invite invite) throws UserNotFoundException;

    List<Invite> getInvites(Long id);
}
