package com.pard.hw5.dto.signIn.response;

import com.pard.hw5.dto.user.response.UserResponseDto;
import com.pard.hw5.entity.posting.PostingEntity;
import com.pard.hw5.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponseDto {
    private String token;
    private int exprTime;
    private UserResponseDto userResponseDto;

    public SignInResponseDto(String token, int exprTime, UserEntity user){
        this.token = token;
        this.exprTime = exprTime;
        this.userResponseDto = new UserResponseDto(user);
    }
}
