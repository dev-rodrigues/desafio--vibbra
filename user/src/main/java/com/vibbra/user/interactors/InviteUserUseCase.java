package com.vibbra.user.interactors;

import com.vibbra.user.datasources.h2.exceptions.UserNotFoundException;
import com.vibbra.user.entities.Invite;
import com.vibbra.user.ports.InvitePort;
import org.springframework.stereotype.Service;

@Service
public class InviteUserUseCase {

    private final InvitePort invitePort;

    public InviteUserUseCase(InvitePort invitePort) {
        this.invitePort = invitePort;
    }

    public Invite inviteUser(Invite invite) {
        return invitePort.inviteUser(invite);
    }
}
