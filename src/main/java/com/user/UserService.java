package com.user;

import com.auth.DTOS.AuthRequest;
import com.common.utils.ResourceCreationResponse;
import com.common.utils.exceptions.ResourcePersistenceException;
import com.user.dtos.NewUserRequest;
import com.user.dtos.UserResponse;
import org.apache.catalina.User;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserResponse> fetchAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(int id) throws Exception {
        return userRepo.findById(id)
                .map(UserResponse::new)
                .orElseThrow(Exception::new);
    }

    public ResourceCreationResponse createUser(@Valid NewUserRequest newUserRequest) throws SQLException {
        Users newUser = newUserRequest.extractResource();

        if (userRepo.existsByEmail(newUser.getEmail())) {
            throw new ResourcePersistenceException("There is already a user with that email address!");
        }
        newUser.setRole(Users.Role.BUYER);
        userRepo.save(newUser);

        return new ResourceCreationResponse(newUser.getId());
    }

    public void deleteUserById(int id) {
        userRepo.deleteById(id);

    }



//    public UserResponse authenticateUserCredentials(@Valid AuthRequest authRequest) {
//        return userRepo.findUserByEmailAndPassword(authRequest.getUsername(), authRequest.getPassword())
//                .map(UserResponse::new)
//                .orElseThrow(AuthenticationException::new);
//    }
}

