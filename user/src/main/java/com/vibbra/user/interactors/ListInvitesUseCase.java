package com.vibbra.user.interactors;

import com.vibbra.user.entities.Invite;
import com.vibbra.user.ports.InvitePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListInvitesUseCase {

    private final InvitePort invitePort;

    public ListInvitesUseCase(InvitePort invitePort) {
        this.invitePort = invitePort;
    }

    public List<Invite> executar(Long id) {
        return invitePort.getInvites(id);
    }

}
