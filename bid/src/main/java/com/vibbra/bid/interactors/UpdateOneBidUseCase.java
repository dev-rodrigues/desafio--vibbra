package com.vibbra.bid.interactors;

import com.vibbra.bid.entities.Bid;
import com.vibbra.bid.transportlayers.mapper.BidTransportMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class UpdateOneBidUseCase {

    private final BidTransportMapper mapper;
    private final CheckIfDealExistsUseCase checkIfDealExistsUseCase;
    private final FindOneBidUseCase findOneBidUseCase;
    private final SaveOneBidUseCase saveOneBidUseCase;

    public UpdateOneBidUseCase(CheckIfDealExistsUseCase checkIfDealExistsUseCase, FindOneBidUseCase findOneBidUseCase, SaveOneBidUseCase saveOneBidUseCase) {
        this.checkIfDealExistsUseCase = checkIfDealExistsUseCase;
        this.findOneBidUseCase = findOneBidUseCase;
        this.saveOneBidUseCase = saveOneBidUseCase;
        this.mapper = Mappers.getMapper(BidTransportMapper.class);
    }

    public Bid executar(BigDecimal idBid, BigDecimal deal, Bid bid, String token) {
        var oldbid = findOneBidUseCase.execute(deal, idBid);

        if (Objects.nonNull(oldbid)) {
            var existDeal = checkIfDealExistsUseCase.execute(deal, token);

            if (existDeal) {
                var updated = update(mapper.map(oldbid), bid);
                return saveOneBidUseCase.execute(deal, updated, token);
            }

            throw new RuntimeException("Deal does not exist");
        }
        throw new RuntimeException("Bid does not exists");
    }

    private Bid update(Bid oldBid, Bid newBid) {
        oldBid.setAccepted(newBid.getAccepted());
        oldBid.setDescription(newBid.getDescription());
        oldBid.setValue(newBid.getValue());
        oldBid.setId(newBid.getId());
        return oldBid;
    }


}
