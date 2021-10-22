package com.vibbra.bid.datasources.h2.mapper;

import com.vibbra.bid.datasources.h2.model.BidModel;
import com.vibbra.bid.entities.Bid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BidModelMapper {

    BidModelMapper INSTANCE = Mappers.getMapper(BidModelMapper.class);

    @Mapping(source = "idDeal", target = "idDeal")
    Bid map(BidModel model);

    @Mapping(source = "idDeal", target = "idDeal")
    BidModel map(Bid bid);
}
