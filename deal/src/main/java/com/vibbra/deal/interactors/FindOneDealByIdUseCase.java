package com.vibbra.deal.interactors;

import com.vibbra.deal.entities.Deal;
import com.vibbra.deal.expections.DealNotLocalizedException;
import com.vibbra.deal.ports.DealPort;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class FindOneDealByIdUseCase {

    private final DealPort port;

    public FindOneDealByIdUseCase(DealPort port) {
        this.port = port;
    }

    public Deal executar(@NotNull BigDecimal id) {
        Optional<Deal> localized = port.findBy(id);
        return localized.orElseThrow(() -> new DealNotLocalizedException("Deal not Localized"));
    }
}
