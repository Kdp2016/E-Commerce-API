package com.auth.DTOS;



import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class AuthRequest {
    private String email;
    private String password;
}
