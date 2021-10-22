package com.vibbra.bid.datasources.h2.repository;

import com.vibbra.bid.datasources.h2.data.BidData;
import com.vibbra.bid.datasources.h2.mapper.BidModelMapper;
import com.vibbra.bid.entities.Bid;
import com.vibbra.bid.ports.BidPort;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BidRepository implements BidPort {

    private BidModelMapper mapper;
    private final BidData data;

    public BidRepository(BidData data) {
        this.data = data;
        this.mapper = BidModelMapper.INSTANCE;
    }

    @Override
    public Bid save(Bid bid) {
        var mapped = mapper.map(bid);
        var saved = data.save(mapped);
        return mapper.map(saved);
    }

    @Override
    public Optional<Bid> findBy(BigDecimal idBid, BigDecimal idDeal) {
        var bid = data.findByIdDealAndId(idDeal, idBid);

        if (Objects.nonNull(bid)) {
            var converted = mapper.map(bid);
            return Optional.of(converted);
        }
        return Optional.empty();
    }

    @Override
    public List<Bid> findAll() {
        var bids = data.findAll();
        return bids.stream().map(it -> mapper.map(it)).collect(Collectors.toList());
    }

    @Override
    public List<Bid> findAllBy(BigDecimal idDeal) {
        var bids = data.findByIdDeal(idDeal);
        return bids.stream().map(it -> mapper.map(it)).collect(Collectors.toList());
    }
}
