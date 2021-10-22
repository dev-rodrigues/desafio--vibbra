package com.vibbra.interactors;

import com.vibbra.deal.transportLayers.openapi.model.MessageResponse;
import com.vibbra.entities.Message;
import com.vibbra.ports.MessagePort;
import com.vibbra.transportlayers.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class UpdateOneMessageOfDealUseCase {

    private final MessageMapper mapper;
    private final FindMessageOfDealUseCase findMessageOfDealUseCase;
    private final MessagePort messagePort;

    public UpdateOneMessageOfDealUseCase(FindMessageOfDealUseCase findMessageOfDealUseCase, MessagePort messagePort) {
        this.findMessageOfDealUseCase = findMessageOfDealUseCase;
        this.messagePort = messagePort;
        this.mapper = MessageMapper.INSTANCE;
    }

    public MessageResponse execute(BigDecimal deal, BigDecimal idMessage, Message message, String token) {

        var oldMessage = findMessageOfDealUseCase.execute(deal, idMessage);

        if (Objects.nonNull(oldMessage)) {
            var newMessage = updateMessage(mapper.map(oldMessage), message);
            newMessage.setIdDeal(deal);
            var updatedMessage = messagePort.save(newMessage);
            return mapper.mapper(updatedMessage);
        }

        throw new RuntimeException("Deal not exist");
    }

    private Message updateMessage(Message oldMessage, Message newMessage) {
        oldMessage.setMessage(newMessage.getMessage());
        oldMessage.setTitle(newMessage.getTitle());
        oldMessage.setUserId(newMessage.getUserId());
        return oldMessage;
    }
}
