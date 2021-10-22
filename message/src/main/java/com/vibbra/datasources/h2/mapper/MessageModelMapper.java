package com.vibbra.datasources.h2.mapper;

import com.vibbra.datasources.h2.model.MessageModel;
import com.vibbra.entities.Message;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageModelMapper {

    MessageModelMapper INSTANCE = Mappers.getMapper(MessageModelMapper.class);

    MessageModel map(Message message);
    Message map(MessageModel messageModel);
}
