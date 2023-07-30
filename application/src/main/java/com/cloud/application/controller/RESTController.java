package com.cloud.application.controller;

import com.cloud.application.entity.ResponseEntity;
import com.cloud.application.exception.TooMantRequestException;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

    //计数器限流100次/s
    private static final RateLimiter limiter = RateLimiter.create(1.0);

    @GetMapping("/")
    public ResponseEntity index() {
        if (limiter.tryAcquire()) {
            return new ResponseEntity("Hello");
        }
        throw new TooMantRequestException("Too Many Request");
    }

}
