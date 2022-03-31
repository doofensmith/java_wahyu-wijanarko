package com.softlaboratory.springbootjwtproject.controller;

import com.softlaboratory.springbootjwtproject.payload.UsernamePassword;
import com.softlaboratory.springbootjwtproject.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody UsernamePassword req) {
        authService.register(req);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/token")
    public ResponseEntity<Object> generateToken(@RequestBody UsernamePassword req) {
        return ResponseEntity.ok(authService.generateToken(req));
    }

}
