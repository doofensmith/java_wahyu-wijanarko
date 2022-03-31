package com.softlaboratory.springbootjwtproject.service.impl;

import com.softlaboratory.springbootjwtproject.model.User;
import com.softlaboratory.springbootjwtproject.repository.UserRepository;
import com.softlaboratory.springbootjwtproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getDistinctTopByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username Not Found.");
        }else {
            return user;
        }
    }

}
