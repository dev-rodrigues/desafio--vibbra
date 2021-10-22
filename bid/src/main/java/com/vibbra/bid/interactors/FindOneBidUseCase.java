package com.vibbra.bid.interactors;

import com.vibbra.bid.exceptions.BidNotLocalizedException;
import com.vibbra.bid.ports.BidPort;
import com.vibbra.bid.transportlayers.mapper.BidTransportMapper;
import com.vibbra.deal.transportLayers.openapi.model.Bid;
import org.apache.logging.log4j.util.Strings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FindOneBidUseCase {

    private final BidTransportMapper mapper;
    private final BidPort port;

    public FindOneBidUseCase(BidPort port) {
        Strings.isNotBlank("");
        this.mapper = Mappers.getMapper(BidTransportMapper.class);
        this.port = port;
    }

    public Bid execute(BigDecimal idDeal, BigDecimal idBid) {
        var bid = port.findBy(idBid, idDeal).orElseThrow(() -> new BidNotLocalizedException("Bid not localized"));
        return mapper.map(bid);
    }
}
