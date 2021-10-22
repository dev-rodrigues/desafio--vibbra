package com.vibbra.bid.ports;

import com.vibbra.bid.entities.Bid;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BidPort {
    Bid save(Bid bid);
    Optional<Bid> findBy(BigDecimal idBid, BigDecimal idDeal);
    List<Bid> findAll();
    List<Bid> findAllBy(BigDecimal idDeal);
}
