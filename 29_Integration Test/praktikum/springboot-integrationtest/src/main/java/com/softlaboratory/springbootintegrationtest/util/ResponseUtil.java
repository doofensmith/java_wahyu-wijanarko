package com.softlaboratory.springbootintegrationtest.util;

import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@SuperBuilder
public class ResponseUtil extends BaseResponse {

    private ResponseUtil() {
        //
    }

    public static ResponseEntity<Object> build(HttpStatus status, String message, Object data) {

        BaseResponse response = BaseResponse.builder()
                .timestamp(LocalDateTime.now())
                .responseCode(String.valueOf(status.value()))
                .message(message)
                .data(data)
                .build();

//        Map<String, Object> map = new HashMap<>();
//        map.put("code", code);
//        map.put("data", data);

        return new ResponseEntity<>(response, status);

    }

}
