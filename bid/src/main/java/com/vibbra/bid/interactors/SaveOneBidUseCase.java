package com.vibbra.bid.interactors;

import com.vibbra.bid.entities.Bid;
import com.vibbra.bid.ports.BidPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SaveOneBidUseCase {

    private final CheckIfDealExistsUseCase checkIfDealExistsUseCase;
    private final BidPort port;

    public SaveOneBidUseCase(BidPort port, CheckIfDealExistsUseCase checkIfDealExistsUseCase) {
        this.port = port;
        this.checkIfDealExistsUseCase = checkIfDealExistsUseCase;
    }

    public Bid execute(BigDecimal deal, Bid bid, String token) {

        var exist = checkIfDealExistsUseCase.execute(deal, token);
        if (exist) {
            bid.setIdDeal(deal);
            return port.save(bid);
        }
        throw new RuntimeException("Deal does not existe");
    }
}
