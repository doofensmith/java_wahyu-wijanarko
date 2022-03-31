package com.softlaboratory.springbootjwtproject.controller;

import com.softlaboratory.springbootjwtproject.payload.UsernamePassword;
import com.softlaboratory.springbootjwtproject.service.AuthService;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v2/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody UsernamePassword req) {
        authService.register(req);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody UsernamePassword req) {
        Map<String, Object> map = new HashMap<>();
        map.put("data",authService.generateToken(req));
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @GetMapping(value = "/info")
    public ResponseEntity<Object> info(HttpServletRequest request) {

        Map<String, Object> phone = new HashMap<>();
        phone.put("phone",authService.extractUsername(request));

        Map<String, Object> response = new HashMap<>();
        response.put("data", phone);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping(value = "/token")
    public ResponseEntity<Object> generateToken(@RequestBody UsernamePassword req) {
        return ResponseEntity.ok(authService.generateToken(req));
    }

}
