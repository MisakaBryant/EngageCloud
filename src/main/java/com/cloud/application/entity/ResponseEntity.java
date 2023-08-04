package com.cloud.application.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@ResponseBody
public class ResponseEntity {
    private String message;

    public ResponseEntity(String message) {
        this.message = message;
    }

}
