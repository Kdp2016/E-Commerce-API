package com.user;

import com.auth.DTOS.AuthRequest;
import com.common.utils.ResourceCreationResponse;
import com.common.utils.exceptions.AuthenticationExceptions;
import com.common.utils.exceptions.ResourceNotFoundException;
import com.common.utils.exceptions.ResourcePersistenceException;
import com.user.dtos.NewUserRequest;
import com.user.dtos.UpdateUserRequest;
import com.user.dtos.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
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
        newUser.setActive(true);
        userRepo.save(newUser);

        return new ResourceCreationResponse(newUser.getId());
    }


    public void activateUser(int id) {
        userRepo.findById(id)
                .orElseThrow(ResourceNotFoundException::new)
                .setActive(true);
    }

    public void deactivateUser(int id) {
        userRepo.findById(id)
                .orElseThrow(ResourceNotFoundException::new)
                .setActive(false);

    }


    public void updateUser(@Valid UpdateUserRequest updatedUserRequest) {

        Users updatedUser = updatedUserRequest.extractResource();
        Users userForUpdate = userRepo.findById(updatedUser.getId()).orElseThrow(ResourceNotFoundException::new);

        if (updatedUser.getFirstName() != null) {
            userForUpdate.setFirstName(updatedUser.getFirstName());
        }

        if (updatedUser.getLastName() != null) {
            userForUpdate.setLastName(updatedUser.getLastName());
        }

        if (updatedUser.getEmail() != null) {
            if (userRepo.existsByEmail(updatedUser.getEmail())) {
                throw new ResourcePersistenceException("There is already a user with that email!");
            }
            userForUpdate.setEmail(updatedUser.getEmail());
        }


        if (updatedUser.getPassword() != null) {
            userForUpdate.setPassword(updatedUser.getPassword());
        }

        if (updatedUser.getRole() != null) {
            userForUpdate.setRole(updatedUser.getRole());
        }


    }


    public UserResponse authenticateUserCredentials(@Valid AuthRequest authRequest) {
        return userRepo.findUserByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword())
                .map(UserResponse::new)
                .orElseThrow(AuthenticationExceptions::new);
    }


}

