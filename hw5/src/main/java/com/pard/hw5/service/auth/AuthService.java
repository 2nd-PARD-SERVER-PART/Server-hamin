package com.pard.hw5.service.auth;

import com.pard.hw5.config.WebSecurityConfig;
import com.pard.hw5.dto.response.ResponseDto;
import com.pard.hw5.dto.signIn.request.SignInRequestDto;
import com.pard.hw5.dto.signIn.response.SignInResponseDto;
import com.pard.hw5.dto.signUp.requset.SignUpRequestDto;
import com.pard.hw5.entity.user.UserEntity;
import com.pard.hw5.repository.user.UserRepository;
import com.pard.hw5.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final WebSecurityConfig webSecurityConfig;

    public ResponseDto<?> signUp(SignUpRequestDto request){
        String userName = request.getUserName();
        String userEmail = request.getUserEmail();
        String userPassword = webSecurityConfig.getPasswordEncoder().encode(request.getUserPassword());
        SignUpRequestDto putDto = new SignUpRequestDto(userName, userEmail, userPassword);
        try {
            if (userRepository.existsByUserEmail(request.getUserEmail())) {
                return ResponseDto.setFailed("Email already exist in DB.");
            }
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to sign up user.");
        }

        UserEntity user = new UserEntity(putDto);
        try{
            userRepository.save(user);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to upload user to DB.");
        }
        return ResponseDto.setSuccess("User sign up success. Please login.", null);
    }

    public ResponseDto<SignInResponseDto> signIn(SignInRequestDto request){
        String userEmail = request.getUserEmail();
        UserEntity user = userRepository.findByUserEmail(userEmail);
        boolean passwordMatch = webSecurityConfig.getPasswordEncoder().matches(request.getUserPassword(), user.getHashedPassword());
        boolean existed = userRepository.existsByUserEmail(userEmail) && passwordMatch;
        if(!existed) return ResponseDto.setFailed("Email or password not correct");
        user.setHashedPassword("");
        String token = tokenProvider.create(user.getId());
        int exprTime = 360000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, user);
        return ResponseDto.setSuccess("Login success.",signInResponseDto);
    }

}
