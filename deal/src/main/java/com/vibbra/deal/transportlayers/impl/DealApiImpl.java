package com.vibbra.deal.transportlayers.impl;

import com.vibbra.deal.interactors.*;
import com.vibbra.deal.transportLayers.openapi.api.DealApi;
import com.vibbra.deal.transportLayers.openapi.model.DealResponse;
import com.vibbra.deal.transportLayers.openapi.model.RequestNewDeal;
import com.vibbra.deal.transportlayers.mapper.DealMapper;
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
public class DealApiImpl implements DealApi {

    private final DealMapper INSTANCE;
    private final FindOneDealByIdUseCase findOneDealByIdUseCase;
    private final SaveOneDealUseCase saveOneDealUseCase;
    private final UpdateOneDealUseCase updateOneDealUseCase;
    private final ListAllDealsUseCase listDeals;
    private final GetTokenParamsUseCase getTokenParamsUseCase;
    private final ValidateTokenUseCase validateTokenUseCase;

    public DealApiImpl(FindOneDealByIdUseCase findOneDealByIdUseCase, SaveOneDealUseCase saveOneDealUseCase, UpdateOneDealUseCase updateOneDealUseCase, ListAllDealsUseCase listDeals, GetTokenParamsUseCase getTokenParamsUseCase, ValidateTokenUseCase validateTokenUseCase) {
        this.findOneDealByIdUseCase = findOneDealByIdUseCase;
        this.saveOneDealUseCase = saveOneDealUseCase;
        this.updateOneDealUseCase = updateOneDealUseCase;
        this.listDeals = listDeals;
        this.getTokenParamsUseCase = getTokenParamsUseCase;
        this.validateTokenUseCase = validateTokenUseCase;
        this.INSTANCE = Mappers.getMapper(DealMapper.class);
    }

    @Override
    public ResponseEntity<DealResponse> persistAdeal(
            @RequestHeader(value="token") String token,
            @RequestBody RequestNewDeal requestNewDeal
    ) {
        DealMapper INSTANCE = Mappers.getMapper(DealMapper.class);
        var deal = INSTANCE.map(requestNewDeal);

        var params = getTokenParamsUseCase.execute(token);
        validateTokenUseCase.execute(params);
        deal.setUserId((Long) params.get("userId"));

        var persistedDeal = saveOneDealUseCase.execute(deal);
        var response = INSTANCE.map(persistedDeal);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(persistedDeal.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @Override
    public ResponseEntity<DealResponse> updateAdeal(
            @RequestHeader(value="token") String token,
            @RequestParam(value = "id") BigDecimal id,
            @RequestBody RequestNewDeal requestNewDeal
    ) {
        var params = getTokenParamsUseCase.execute(token);
        validateTokenUseCase.execute(params);

        var userId = (Long) params.get("userId");
        updateOneDealUseCase.execute(id, requestNewDeal, userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<DealResponse>> listDeals(
            @RequestHeader(value="token") String token
    ) {
        var deals = listDeals.executar();

        var response = new ArrayList<DealResponse>();

        deals.forEach(it -> response.add(INSTANCE.map(it)));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<DealResponse> getBidById(
            @RequestHeader(value="token") String token,
            @PathVariable("id") BigDecimal id) {

        var deal = findOneDealByIdUseCase.executar(id);
        var response = INSTANCE.map(deal);
        return ResponseEntity.ok(response);
    }
}
