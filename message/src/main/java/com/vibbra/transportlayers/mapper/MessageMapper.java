package com.vibbra.transportlayers.mapper;


import com.vibbra.deal.transportLayers.openapi.model.Message;
import com.vibbra.deal.transportLayers.openapi.model.MessageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    Message map(com.vibbra.entities.Message message);

    com.vibbra.entities.Message map(MessageResponse messageResponse);

    MessageResponse mapper(com.vibbra.entities.Message message);

    com.vibbra.entities.Message map(Message message);
}
