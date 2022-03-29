package com.softlaboratory.relationaldbproject.util;

import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@SuperBuilder
public class ResponseUtil extends BaseResponse {

    private ResponseUtil() {
        //
    }

    public static ResponseEntity<Object> build(HttpStatus httpStatus, String message, Object data) {

        BaseResponse response = BaseResponse.builder()
                .timestamp(LocalDateTime.now())
                .responseCode(String.valueOf(httpStatus.value()))
                .message(message)
                .data(data)
                .build();

        return new ResponseEntity<>(response, httpStatus);

    }

}
