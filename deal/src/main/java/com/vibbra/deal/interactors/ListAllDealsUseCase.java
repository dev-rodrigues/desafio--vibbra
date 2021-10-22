package com.vibbra.deal.interactors;

import com.vibbra.deal.entities.Deal;
import com.vibbra.deal.ports.DealPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllDealsUseCase {

    private final DealPort port;

    public ListAllDealsUseCase(DealPort port) {
        this.port = port;
    }

    public List<Deal> executar() {
        return port.findAll();
    }
}
