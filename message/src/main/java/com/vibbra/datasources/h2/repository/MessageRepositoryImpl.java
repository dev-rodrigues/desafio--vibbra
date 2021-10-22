package com.vibbra.datasources.h2.repository;

import com.vibbra.datasources.h2.data.MessageData;
import com.vibbra.datasources.h2.mapper.MessageModelMapper;
import com.vibbra.entities.Message;
import com.vibbra.exceptions.MessageNotLocalizedException;
import com.vibbra.ports.MessagePort;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MessageRepositoryImpl implements MessagePort {

    private final MessageData data;
    private MessageModelMapper mapper;

    public MessageRepositoryImpl(MessageData data) {
        mapper = MessageModelMapper.INSTANCE;
        this.data = data;
    }

    @Override
    public Message save(Message message) {
        var messageModel = mapper.map(message);
        var saved = data.save(messageModel);
        return mapper.map(saved);
    }

    @Override
    public List<Message> messagesOfDeal(BigDecimal idDeal) {
        var messages = data.findAllByIdDeal(idDeal);
        return messages.stream().map(it -> mapper.map(it)).collect(Collectors.toList());
    }

    @Override
    public Message findBy(BigDecimal id) {
        var message = data.findById(id).orElseThrow(() -> new MessageNotLocalizedException("Message not Localized"));
        return mapper.map(message);
    }
}
