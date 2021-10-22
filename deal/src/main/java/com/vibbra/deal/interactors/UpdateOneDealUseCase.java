package com.vibbra.deal.interactors;

import com.vibbra.deal.entities.Deal;
import com.vibbra.deal.expections.UserNotAuthorizedException;
import com.vibbra.deal.ports.DealPort;
import com.vibbra.deal.transportLayers.openapi.model.RequestNewDeal;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Service
public class UpdateOneDealUseCase {

    private final FindOneDealByIdUseCase findOneDeal;
    private final DealPort port;

    public UpdateOneDealUseCase(FindOneDealByIdUseCase findOneDeal, DealPort port) {
        this.findOneDeal = findOneDeal;
        this.port = port;
    }

    public Deal execute(BigDecimal id, RequestNewDeal newDeal, Long userId) {
        var oldDeal = findOneDeal.executar(id);

        if (Objects.equals(oldDeal.getUserId(), userId))
            return port.save(updateParams(oldDeal, newDeal));

        throw new UserNotAuthorizedException("User not authorized");
    }

    private Deal updateParams(Deal oldDeal, RequestNewDeal newDeal) {
        oldDeal.setTypeOfDeal(newDeal.getType().getType().getValue());
        oldDeal.setValue(newDeal.getValue());
        oldDeal.setDescription(newDeal.getDescription());
        oldDeal.setTypeOfDeal(newDeal.getTradeFor());
        oldDeal.setTradeFor(newDeal.getTradeFor());

        oldDeal.setLat(newDeal.getLocation().getLat());
        oldDeal.setLng(newDeal.getLocation().getLng());
        oldDeal.setAddress(newDeal.getLocation().getAddress());
        oldDeal.setCity(newDeal.getLocation().getCity());
        oldDeal.setState(newDeal.getLocation().getState());
        oldDeal.setZipCode(newDeal.getLocation().getZipCode());

        oldDeal.setUrgency(newDeal.getUrgency().getType().getValue());

        var limitDate = newDeal.getUrgency().getLimitDate();
        var date = Date.from(Instant.from(limitDate.atStartOfDay(ZoneId.systemDefault()))).toInstant();

        oldDeal.setUrgency(date.toString());

        return oldDeal;
    }
}
