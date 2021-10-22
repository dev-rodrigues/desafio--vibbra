package com.vibbra.datasources.repository;

import com.vibbra.datasources.http.DealClient;
import com.vibbra.datasources.http.data.response.DealResponse;
import com.vibbra.exceptions.DealNotLocalizedException;
import com.vibbra.ports.DealPort;
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
            return Optional.ofNullable(response.getBody());
        }

        throw new DealNotLocalizedException("Deal not localized");
    }
}
