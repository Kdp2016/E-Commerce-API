package com.auth;


import com.auth.DTOS.AuthRequest;
import com.auth.DTOS.Principal;
import com.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
@Transactional
public class AuthService {
    private final UserService userService;

    @Autowired
    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public Principal authenticate(@Valid AuthRequest authRequest) {
        return null;
    }
}
