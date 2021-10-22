package com.vibbra.interactors;

import com.vibbra.entities.Message;
import com.vibbra.ports.MessagePort;
import com.vibbra.transportlayers.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateOneMessageUseCase {

    private final MessageMapper mapper;
    private final CheckIfDealExistsUseCase checkIfDealExistsUseCase;
    private final MessagePort messagePort;

    public CreateOneMessageUseCase(CheckIfDealExistsUseCase checkIfDealExistsUseCase, MessagePort messagePort) {
        this.mapper = MessageMapper.INSTANCE;
        this.checkIfDealExistsUseCase = checkIfDealExistsUseCase;
        this.messagePort = messagePort;
    }

    public Message execute(BigDecimal idDeal, Message message, String token) {

        if (checkIfDealExistsUseCase.execute(idDeal, token)) {
            message.setIdDeal(idDeal);
            return messagePort.save(message);
        }
        throw new RuntimeException("Deal does not exist");
    }
}
