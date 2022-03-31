package com.softlaboratory.springbootjwtproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @GetMapping(value = "")
    public ResponseEntity<Object> hello() {
        return ResponseEntity.ok("Hello");
    }

}
