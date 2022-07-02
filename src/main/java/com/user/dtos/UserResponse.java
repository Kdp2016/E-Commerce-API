package com.user.dtos;

import com.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Users.Role role;
    private boolean isActive;


    public UserResponse(Users user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.isActive = user.isActive();
    }

    public UserResponse(UserResponse authUser) {
        this.id = authUser.getId();
        this.firstName = authUser.getFirstName();
        this.lastName = authUser.getLastName();
        this.email = authUser.getEmail();
        this.role = authUser.getRole();
        this.isActive = authUser.isActive;
    }
}
