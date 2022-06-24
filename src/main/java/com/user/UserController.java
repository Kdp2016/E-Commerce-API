package com.user;

import com.user.dtos.NewUserRequest;
import com.user.dtos.UserResponse;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;

    @Autowired
    public UserController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @GetMapping(produces = "application/json")
    public List<UserResponse> getAllUsers(@RequestHeader(value = "Authorization", required = false) String token) {
        Principal requester = tokenService.extractTokenDetails(token)
                .orElseThrow(() -> new AuthenticationException("No auth token found on request!"));

        if (!requester.getAuthUserRole().equals("ADMIN")) {
            throw new AuthorizationException("You are not allowed to hit this endpoint based on your role!");
        }

        return userService.fetchAllUsers();
    }

    @GetMapping("/id/{userId}")
    public UserResponse getUserById(@PathVariable String userId) {
        return userService.fetchUserById(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResourceCreationResponse postNewUser(@RequestBody NewUserRequest newUser) {
        return userService.createUser(newUser);
    }

}