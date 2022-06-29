package com.auth.DTOS;

import com.user.dtos.UserResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Principal {
    private String authUserId;
    private String authUserRole;

    public Principal(UserResponse user) {
        this.authUserId = String.valueOf(user.getId());
        this.authUserRole = String.valueOf(user.getRole());
    }

    public Principal(String authUserId, String authUserRole) {
        this.authUserId = authUserId;
        this.authUserRole = authUserRole;
    }
}
