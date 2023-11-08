package com.pard.hw5.dto.signUp.requset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {
    private String userName;
    private String userEmail;
    private String userPassword;
}
