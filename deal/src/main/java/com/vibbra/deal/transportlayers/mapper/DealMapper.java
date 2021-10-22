package com.vibbra.deal.transportlayers.mapper;

import com.vibbra.deal.entities.Deal;
import com.vibbra.deal.transportLayers.openapi.model.DealResponse;
import com.vibbra.deal.transportLayers.openapi.model.RequestNewDeal;
import com.vibbra.deal.transportLayers.openapi.model.TypesOfDeals;
import com.vibbra.deal.transportLayers.openapi.model.Urgency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DealMapper {

    DealMapper INSTANCE = Mappers.getMapper(DealMapper.class);

    @Mapping(source = "urgency", target = "urgency", qualifiedByName = "enumUrgencyToString")
    @Mapping(source = "urgency.limitDate", target = "urgencyDate")
    @Mapping(source = "type", target = "typeOfDeal", qualifiedByName = "enumTypeOfDealToString")
    @Mapping(source = "location.lat", target = "lat")
    @Mapping(source = "location.lng", target = "lng")
    @Mapping(source = "location.address", target = "address")
    @Mapping(source = "location.city", target = "city")
    @Mapping(source = "location.state", target = "state")
    @Mapping(source = "location.zipCode", target = "zipCode")
    Deal map(RequestNewDeal request);

    @Mapping(source = "urgency", target = "urgency.type")
    @Mapping(source = "urgencyDate", target = "urgency.limitDate")
    @Mapping(source = "lat", target = "location.lat")
    @Mapping(source = "lng", target = "location.lng")
    @Mapping(source = "address", target = "location.address")
    @Mapping(source = "city", target = "location.city")
    @Mapping(source = "state", target = "location.state")
    @Mapping(source = "zipCode", target = "location.zipCode")
    @Mapping(source = "typeOfDeal", target = "type")
    DealResponse map(Deal deal);


    @Named("enumUrgencyToString")
    default String enumUrgencyToString(Urgency urgency) {
        return urgency.getType().getValue();
    }

    @Named("enumTypeOfDealToString")
    default String enunTypeOfDealToString(TypesOfDeals typesOfDeals) {
        return typesOfDeals.getType().getValue();
    }

}
