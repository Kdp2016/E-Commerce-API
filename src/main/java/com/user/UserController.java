package com.user;

import com.common.utils.ResourceCreationResponse;
import com.common.utils.web.security.Secured;
import com.user.dtos.NewUserRequest;
import com.user.dtos.UpdateUserRequest;
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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(consumes = "application/json")
    public void updateUserInfo(@RequestBody UpdateUserRequest updatedUserInfo) {
        userService.updateUser(updatedUserInfo);
    }


    @PatchMapping("/activation/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //    @Secured(allowedRoles = {"ADMIN"})
    public void activateUser(@RequestParam int id) {
        userService.activateUser(id);
    }

    @DeleteMapping("/delete/")
//    @Secured(allowedRoles = {"ADMIN"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateUser(@RequestParam int id) {
        userService.deactivateUser(id);
    }
}