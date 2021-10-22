package com.vibbra.bid.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FeignClienteRetryerConfig extends GenericFeignClientRetryerConfig {
    public FeignClienteRetryerConfig(
            @Value("${feign.client.config.deal-client.numberRetry}") int retryMaxAttempt,
            @Value("${feign.client.config.deal-client.retryInterval}") long retryInterval) {
        super(retryMaxAttempt, retryInterval);
    }
}
