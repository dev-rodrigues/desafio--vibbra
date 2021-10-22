package com.vibbra.bid.transportlayers.impl;

import com.vibbra.bid.interactors.*;
import com.vibbra.bid.transportlayers.mapper.BidTransportMapper;
import com.vibbra.deal.transportLayers.openapi.api.ApiApi;
import com.vibbra.deal.transportLayers.openapi.model.Bid;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ApiImpl implements ApiApi {

    private final ListBidsOfDealUseCase listBidsUseCase;
    private final FindOneBidUseCase findOneBidUseCase;
    private final SaveOneBidUseCase saveOneBidUseCase;
    private final UpdateOneBidUseCase updateOneBidUseCase;
    private final BidTransportMapper mapper;
    private final GetTokenParamsUseCase getTokenParamsUseCase;
    private final ValidateTokenUseCase validateTokenUseCase;

    public ApiImpl(ListBidsOfDealUseCase listBidsUseCase,
                   FindOneBidUseCase findOneBidUseCase,
                   SaveOneBidUseCase saveOneBidUseCase,
                   UpdateOneBidUseCase updateOneBidUseCase, GetTokenParamsUseCase getTokenParamsUseCase, ValidateTokenUseCase validateTokenUseCase) {
        this.listBidsUseCase = listBidsUseCase;
        this.saveOneBidUseCase = saveOneBidUseCase;
        this.updateOneBidUseCase = updateOneBidUseCase;
        this.getTokenParamsUseCase = getTokenParamsUseCase;
        this.validateTokenUseCase = validateTokenUseCase;
        this.mapper = Mappers.getMapper(BidTransportMapper.class);
        this.findOneBidUseCase = findOneBidUseCase;
    }

    @Override
    public ResponseEntity<List<Bid>> listBids(@PathVariable("idDeal") BigDecimal idDeal) {
        var response = new ArrayList<Bid>();
        var bids = listBidsUseCase.execute(idDeal);
        bids.forEach(it -> response.add(mapper.map(it)));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Bid> getBidById(@PathVariable("idDeal") BigDecimal idDeal, @PathVariable("idBid") BigDecimal idBid) {
        var response = findOneBidUseCase.execute(idDeal, idBid);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Bid> createOneBid(
            @PathVariable("idDeal") BigDecimal idDeal,
            @RequestHeader(value="token") String token,
            @RequestBody Bid bid) {

        var params = getTokenParamsUseCase.execute(token);
        validateTokenUseCase.execute(params);

        var request = mapper.map(bid);
        var persisted = saveOneBidUseCase.execute(idDeal, request, token);
        var response = mapper.map(persisted);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(persisted.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @Override
    public ResponseEntity<Bid> updateOneBid(
            @PathVariable("idDeal") BigDecimal idDeal,
            @RequestParam(value = "idBid") BigDecimal idBid,
            @RequestHeader(value="token") String token,
            @RequestBody Bid bid) {

        var params = getTokenParamsUseCase.execute(token);
        validateTokenUseCase.execute(params);

        var convertedBid = mapper.map(bid);
        updateOneBidUseCase.executar(idBid, idDeal, convertedBid, token);
        return ResponseEntity.noContent().build();
    }
}
