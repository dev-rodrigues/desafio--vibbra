package com.vibbra.bid.transportlayers.mapper;

import com.vibbra.deal.transportLayers.openapi.model.Bid;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BidTransportMapper {

    BidTransportMapper INSTANCE = Mappers.getMapper(BidTransportMapper.class);

    Bid map(com.vibbra.bid.entities.Bid bid);
    com.vibbra.bid.entities.Bid map(Bid bid);
}
