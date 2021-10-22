package com.vibbra.deal.interactors;

import com.vibbra.deal.entities.Deal;
import com.vibbra.deal.ports.DealPort;
import org.springframework.stereotype.Service;

@Service
public class SaveOneDealUseCase {

    private final DealPort port;

    public SaveOneDealUseCase(DealPort port) {
        this.port = port;
    }

    public Deal execute(Deal deal) {
        return port.save(deal);
    }
}
