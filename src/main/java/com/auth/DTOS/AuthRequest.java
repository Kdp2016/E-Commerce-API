package com.auth.DTOS;
import javax.validation.constraints.Pattern;

import com.common.utils.RegexUtil;
import com.common.utils.ValidatorMessageUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Data
@NoArgsConstructor
public class AuthRequest {
    @Length(
            message = ValidatorMessageUtil.USERNAME_REQUIREMENTS,
            min = 3)
    private String username;

    @Pattern(
            message = ValidatorMessageUtil.PASSWORD_REQUIREMENTS,
            regexp = RegexUtil.PASSWORD)
    private String password;
}
