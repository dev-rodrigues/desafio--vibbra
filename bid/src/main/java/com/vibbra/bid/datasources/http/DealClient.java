package com.vibbra.bid.datasources.http;

import com.vibbra.bid.datasources.http.data.response.DealResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@FeignClient(name = "deal", url = "http://localhost:8081/deal")
public interface DealClient {

    @RequestMapping("/{id}")
    ResponseEntity<DealResponse> getBidById(
            @PathVariable("id") BigDecimal id,
            @RequestHeader(value="token") String token
    );
}
