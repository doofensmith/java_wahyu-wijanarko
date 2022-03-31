package com.softlaboratory.springbootjwtproject.service.impl;

import com.softlaboratory.springbootjwtproject.model.User;
import com.softlaboratory.springbootjwtproject.payload.TokenResponse;
import com.softlaboratory.springbootjwtproject.payload.UsernamePassword;
import com.softlaboratory.springbootjwtproject.repository.UserRepository;
import com.softlaboratory.springbootjwtproject.security.JwtTokenProvider;
import com.softlaboratory.springbootjwtproject.service.AuthService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User register(UsernamePassword req) {
        User user = new User();
        user.setUsername(req.getPhone());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public TokenResponse login(UsernamePassword req) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getPhone(),
                            req.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenProvider.generateToken(authentication);
            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setToken(jwt);
            return tokenResponse;
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public TokenResponse generateToken(UsernamePassword req) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getPhone(),
                            req.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenProvider.generateToken(authentication);
            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setToken(jwt);
            return tokenResponse;
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public String extractUsername(HttpServletRequest request) {
        String tokenBearer = request.getHeader("Authorization");
        String token = tokenBearer.substring(7);

        return jwtTokenProvider.getUsername(token);
    }

}
