package com.vibbra.transportlayers.api;

import com.vibbra.deal.transportLayers.openapi.api.ApiApi;
import com.vibbra.deal.transportLayers.openapi.model.Message;
import com.vibbra.deal.transportLayers.openapi.model.MessageResponse;
import com.vibbra.interactors.*;
import com.vibbra.transportlayers.mapper.MessageMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/")
public class MessageApiImpl implements ApiApi {

    private final MessageMapper mapper;
    private final FindMessagesOfDealsUseCase findMessagesOfDealsUseCase;
    private final FindMessageOfDealUseCase findMessageOfDealUseCase;
    private final CreateOneMessageUseCase createOneMessageUseCase;
    private final UpdateOneMessageOfDealUseCase updateOneMessageOfDealUseCase;
    private final GetTokenParamsUseCase getTokenParamsUseCase;
    private final ValidateTokenUseCase validateTokenUseCase;

    public MessageApiImpl(FindMessagesOfDealsUseCase findMessagesOfDealsUseCase, FindMessageOfDealUseCase findMessageOfDealUseCase, CreateOneMessageUseCase createOneMessageUseCase, UpdateOneMessageOfDealUseCase updateOneMessageOfDealUseCase, GetTokenParamsUseCase getTokenParamsUseCase, ValidateTokenUseCase validateTokenUseCase) {
        this.createOneMessageUseCase = createOneMessageUseCase;
        this.updateOneMessageOfDealUseCase = updateOneMessageOfDealUseCase;
        this.getTokenParamsUseCase = getTokenParamsUseCase;
        this.validateTokenUseCase = validateTokenUseCase;
        this.mapper = Mappers.getMapper(MessageMapper.class);
        this.findMessagesOfDealsUseCase = findMessagesOfDealsUseCase;
        this.findMessageOfDealUseCase = findMessageOfDealUseCase;
    }

    @Override
    public ResponseEntity<List<MessageResponse>> getMessageOfDeal(@PathVariable("idDeal") BigDecimal idDeal) {
        var response = findMessagesOfDealsUseCase.execute(idDeal);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<MessageResponse> getMessageById(
            @PathVariable("idDeal") BigDecimal idDeal,
            @PathVariable("id") BigDecimal id) {
        var response = findMessageOfDealUseCase.execute(idDeal, id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<MessageResponse> createOneMessage(
            @RequestParam(value = "idDeal") BigDecimal idDeal,
            @RequestHeader(value="token") String token,
            @RequestBody Message message
    ) {
        var params = getTokenParamsUseCase.execute(token);
        validateTokenUseCase.execute(params);

        var request = mapper.map(message);
        var response = createOneMessageUseCase.execute(idDeal, request, token);
        var responseConverted = mapper.mapper(response);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(responseConverted);
    }

    @Override
    public ResponseEntity<MessageResponse> updateOneMessage(
            @PathVariable("idDeal") BigDecimal idDeal,
            @PathVariable("id") BigDecimal id,
            @RequestHeader(value="token") String token,
            @RequestBody Message message)
    {
        var params = getTokenParamsUseCase.execute(token);
        validateTokenUseCase.execute(params);

        var request = mapper.map(message);
        updateOneMessageOfDealUseCase.execute(idDeal, id, request, token);
        return ResponseEntity.noContent().build();
    }
}