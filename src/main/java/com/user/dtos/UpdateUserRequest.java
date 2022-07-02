package com.user.dtos;

import com.common.utils.ValidatorMessageUtil;
import com.user.UserService;
import com.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import sun.security.util.Password;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UpdateUserRequest {


    @NotNull
    private int id;

    @Email(message = ValidatorMessageUtil.EMAIL_REQUIREMENTS)
    private String email;

    @Length(  message = ValidatorMessageUtil.FNAME_REQUIREMENTS,
            min = 1)
    private String firstName;

    @Length(  message = ValidatorMessageUtil.LNAME_REQUIREMENTS,
            min = 1)
    private String lastName;

    @Length( message = ValidatorMessageUtil.PASSWORD_REQUIREMENTS, min = 8)
    private String password;
    private Users.Role role;
    private boolean isActive;

    public Users extractResource() {


        if (role == null) {
            return new Users(id, firstName, lastName, email, password, Users.Role.BUYER, isActive);
        }

        return new Users(id, firstName, lastName, email, password, role, isActive);
    }

    @Override
    public String toString() {
        return "UpdateUserRequest{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", isActive=" + isActive +
                '}';
    }


}
