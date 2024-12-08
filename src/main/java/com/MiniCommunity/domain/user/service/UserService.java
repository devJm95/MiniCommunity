package com.MiniCommunity.domain.user.service;

import com.MiniCommunity.common.component.FinderId;
import com.MiniCommunity.domain.user.dto.UserCreateDTO;
import com.MiniCommunity.domain.user.dto.UserResponseDTO;
import com.MiniCommunity.domain.user.dto.UserUpdateDTO;
import com.MiniCommunity.domain.user.entity.User;
import com.MiniCommunity.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final FinderId finderId;
    private final Pattern passwordPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    //private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {

        // 1. 아이디 중복 확인
        if (userRepository.findByUserName(userCreateDTO.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }

        // 2. 비밀번호 정규식 검증
        if (!passwordPattern.matcher(userCreateDTO.getPassword()).matches()) {
            throw new IllegalArgumentException(
                    "비밀번호 최소 8자 이상, 대, 소문자 숫자를 결합한 비밀번호를 입력해주세요."
            );
        }

        // 3. 비밀번호 암호화
//        String encodedPassword = passwordEncoder.encode(userCreateDTO.getPassword());
//        User user = userCreateDTO.toEntity(encodedPassword);
        User user = userCreateDTO.toEntityTemp();
        userRepository.save(user);
        return UserResponseDTO.fromEntity(user);

    }

    @Transactional
    public UserResponseDTO updateUser(Long id, UserUpdateDTO userUpdateDTO){
        User user = finderId.findById(userRepository, id, "User");

        if (userUpdateDTO.getPassword() != null) {
            // 비밀번호 정규식 검증
            if (!passwordPattern.matcher(userUpdateDTO.getPassword()).matches()) {
                throw new IllegalArgumentException(
                        "비밀번호 최소 8자 이상, 대, 소문자 숫자를 결합한 비밀번호를 입력해주세요."
                );
            }
            // 비밀번호 암호화 후 업데이트
            //user.setPassword(passwordEncoder.encode(userUpdateDTO.getPassword()));
        }
        //.... 필요한 로직은 나중에 추가
        userRepository.save(user);
        return UserResponseDTO.fromEntity(user);
    }

}
