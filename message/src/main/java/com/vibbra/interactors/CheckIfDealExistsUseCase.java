package com.vibbra.interactors;

import com.vibbra.ports.DealPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CheckIfDealExistsUseCase {

    private final DealPort dealPort;

    public CheckIfDealExistsUseCase(DealPort dealPort) {
        this.dealPort = dealPort;
    }

    public boolean execute(BigDecimal id, String token) {
        var response = dealPort.getById(id, token);
        return response.isPresent();
    }
}
