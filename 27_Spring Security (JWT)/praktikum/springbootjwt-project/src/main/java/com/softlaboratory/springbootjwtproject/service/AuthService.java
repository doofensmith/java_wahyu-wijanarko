package com.softlaboratory.springbootjwtproject.service;


import com.softlaboratory.springbootjwtproject.model.User;
import com.softlaboratory.springbootjwtproject.payload.TokenResponse;
import com.softlaboratory.springbootjwtproject.payload.UsernamePassword;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

    User register(UsernamePassword req);
    TokenResponse login(UsernamePassword req);
    TokenResponse generateToken(UsernamePassword req);
    String extractUsername(HttpServletRequest request);

}
