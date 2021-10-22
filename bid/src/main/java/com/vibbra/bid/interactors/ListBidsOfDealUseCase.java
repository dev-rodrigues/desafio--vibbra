package com.vibbra.bid.interactors;

import com.vibbra.bid.entities.Bid;
import com.vibbra.bid.ports.BidPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ListBidsOfDealUseCase {

    private final BidPort port;

    public ListBidsOfDealUseCase(BidPort port) {
        this.port = port;
    }

    public List<Bid> execute(BigDecimal idDeal) {
        return port.findAllBy(idDeal);
    }
}
