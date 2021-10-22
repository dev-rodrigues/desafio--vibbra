package com.vibbra.deal.datasources.h2.mapper;

import com.vibbra.deal.datasources.h2.model.DealModel;
import com.vibbra.deal.entities.Deal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DealModelMapper {

    DealModelMapper INSTANCE = Mappers.getMapper(DealModelMapper.class);

    Deal map(DealModel request);

    DealModel map(Deal request);
}
