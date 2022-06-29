package com.auth;


import com.auth.DTOS.AuthRequest;
import com.auth.DTOS.Principal;
import com.user.UserService;
import com.user.dtos.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final TokenService tokenService;

    @Autowired
    public AuthController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public UserResponse authenticate(@RequestBody AuthRequest authRequest, HttpServletResponse resp) {
        UserResponse authUser = userService.authenticateUserCredentials(authRequest);
        UserResponse payload = new UserResponse(authUser);
        String token = tokenService.generateToken(payload);
        resp.setHeader("Authorization", token);
        return payload;
    }
}
