package com.vibbra.configs;

import feign.RetryableException;
import feign.Retryer;

public class GenericFeignClientRetryerConfig implements Retryer {

    protected int retryMaxAttempt;
    protected long retryInterval;
    private int attempt = 1;

    public GenericFeignClientRetryerConfig(int retryMaxAttempt, long retryInterval) {
        this.retryMaxAttempt = retryMaxAttempt;
        this.retryInterval = retryInterval;
    }

    @Override
    public void continueOrPropagate(RetryableException e) {
        if (attempt ++ == retryMaxAttempt) {
            throw new RuntimeException("maximum connection attempts with deal");
        }
        try {
            Thread.sleep(retryInterval);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Retryer clone() {
        return new GenericFeignClientRetryerConfig(retryMaxAttempt, retryInterval);
    }
}
