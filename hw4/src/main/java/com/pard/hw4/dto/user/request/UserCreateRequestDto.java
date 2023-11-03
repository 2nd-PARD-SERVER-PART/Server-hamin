package com.pard.hw4.dto.user.request;

import com.pard.hw4.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto {
    private String name;
    private String email;
    private String password;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
