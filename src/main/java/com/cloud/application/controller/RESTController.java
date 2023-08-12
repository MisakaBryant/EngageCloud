package com.cloud.application.controller;

import com.cloud.application.entity.ResponseEntity;
import com.cloud.application.exception.TooManyRequestException;
import com.cloud.application.metrics.QPSMetrics;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

    //计数器限流100次/s
    private static final RateLimiter limiter = RateLimiter.create(100.0);

    @Autowired
    private QPSMetrics QPSMetrics;

    @GetMapping("/")
    public ResponseEntity index() {
        //尝试获取令牌
        if (limiter.tryAcquire()) {
            QPSMetrics.increment();
            return new ResponseEntity("Hello");
        }
        throw new TooManyRequestException("Too Many Request");
    }

}
