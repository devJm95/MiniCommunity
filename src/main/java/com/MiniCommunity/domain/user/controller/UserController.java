package com.MiniCommunity.domain.user.controller;

import com.MiniCommunity.domain.user.dto.UserCreateDTO;
import com.MiniCommunity.domain.user.dto.UserResponseDTO;
import com.MiniCommunity.domain.user.dto.UserUpdateDTO;
import com.MiniCommunity.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userCreateDTO){
        UserResponseDTO response = userService.createUser(userCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO){
        UserResponseDTO response = userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
