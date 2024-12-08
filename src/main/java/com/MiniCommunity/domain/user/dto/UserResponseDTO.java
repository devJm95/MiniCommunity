package com.MiniCommunity.domain.user.dto;


import com.MiniCommunity.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String username;
    private String email;
    private LocalDateTime cDt;

    public static UserResponseDTO fromEntity(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCDt()
        );
    }
}
