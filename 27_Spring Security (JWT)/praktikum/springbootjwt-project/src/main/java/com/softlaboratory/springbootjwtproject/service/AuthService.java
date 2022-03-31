package com.softlaboratory.springbootjwtproject.service;


import com.softlaboratory.springbootjwtproject.model.User;
import com.softlaboratory.springbootjwtproject.payload.TokenResponse;
import com.softlaboratory.springbootjwtproject.payload.UsernamePassword;

public interface AuthService {

    User register(UsernamePassword req);
    TokenResponse generateToken(UsernamePassword req);

}
