package com.MiniCommunity.domain.user.dto;

import com.MiniCommunity.domain.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.MiniCommunity.domain.user.Role.USER;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 6)
    private String password;

    @Email
    private String email;

    public User toEntity(String encodedPassword) {
        return User.builder()
                .username(username)
                .password(encodedPassword)
                .email(email)
                .isActive(true)
                .role(USER)
                .build();
    }

    public User toEntityTemp() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .isActive(true)
                .role(USER)
                .build();
    }
}
