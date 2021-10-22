package com.vibbra.bid.datasources.repository;

import com.vibbra.bid.datasources.http.DealClient;
import com.vibbra.bid.datasources.http.data.response.DealResponse;
import com.vibbra.bid.exceptions.DealNotLocalizedException;
import com.vibbra.bid.ports.DealPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class DealRepository implements DealPort {

    private final DealClient client;

    public DealRepository(DealClient client) {
        this.client = client;
    }

    @Override
    public Optional<DealResponse> getById(BigDecimal id, String token) {
        var response = client.getBidById(id, token);

        if (response.getStatusCode().is2xxSuccessful()) {
            return Optional.of(response.getBody());
        }
        throw new DealNotLocalizedException("Deal not Localized");
    }
}
