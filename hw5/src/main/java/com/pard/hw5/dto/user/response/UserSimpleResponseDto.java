package com.pard.hw5.dto.user.response;

import com.pard.hw5.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSimpleResponseDto {
    private Long id;
    private String userName;
    private String userEmail;

    public UserSimpleResponseDto(UserEntity user){
        this.id = user.getId();
        this.userName = user.getUserName();
        this.userEmail = user.getUserEmail();
    }
}
