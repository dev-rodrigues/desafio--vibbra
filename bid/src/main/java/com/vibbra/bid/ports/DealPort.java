package com.vibbra.bid.ports;

import com.vibbra.bid.datasources.http.data.response.DealResponse;

import java.math.BigDecimal;
import java.util.Optional;

public interface DealPort {
    Optional<DealResponse> getById(BigDecimal id, String token);
}
