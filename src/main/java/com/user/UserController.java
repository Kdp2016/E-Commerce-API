package com.user;

import com.common.utils.ResourceCreationResponse;
import com.user.dtos.NewUserRequest;
import com.user.dtos.UserResponse;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public List<UserResponse> getAllUsers() {
//        Principal requester = tokenService.extractTokenDetails(token)
//                .orElseThrow(() -> new AuthenticationException("No auth token found on request!"));

//        if (!requester.getAuthUserRole().equals("ADMIN")) {
//            throw new AuthorizationException("You are not allowed to hit this endpoint based on your role!");
//        }

        return userService.fetchAllUsers();
    }

    @GetMapping("/id/{userId}")
    public UserResponse getUserById(@PathVariable int userId) throws Exception {
        return userService.getUserById(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResourceCreationResponse postNewUser(@RequestBody NewUserRequest newUser) throws SQLException {
        return userService.createUser(newUser);
    }

    @PostMapping("/delete/{userId}")
    public void deleteUserById(@PathVariable int userId) {
        userService.deleteUserById(userId);
    }
}