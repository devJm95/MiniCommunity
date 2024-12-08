package com.MiniCommunity.domain.user.dto;

import com.MiniCommunity.domain.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String userName;
    private String email;
    private Role role;
}
