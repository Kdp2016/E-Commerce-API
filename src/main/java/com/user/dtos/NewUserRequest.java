package com.user.dtos;

import com.user.UserService;
import com.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import sun.security.util.Password;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class NewUserRequest {

    @Email
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Pattern(regexp = "\"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\"")
    private String password;

    @NotNull
    private Users.Role role;
    
    public Users extractResource() {
        return new Users(firstName, lastName, email, password, role);
    }

    @Override
    public String toString() {
        return "NewUserRequest{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
