package com.softlaboratory.springcrudproduct.util;

import com.softlaboratory.springcrudproduct.domain.dao.ProductDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    private ResponseUtil() {
        //
    }

    public static ResponseEntity<Object> build(HttpStatus status, String code, Object data) {

        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("data", data);

        return new ResponseEntity<>(map, status);

    }

}
