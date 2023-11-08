package com.pard.hw5.controller.auth.signIn;

import com.pard.hw5.dto.response.ResponseDto;
import com.pard.hw5.dto.signIn.request.SignInRequestDto;
import com.pard.hw5.dto.signIn.response.SignInResponseDto;
import com.pard.hw5.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class SignInController {

    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInRequestDto dto){
        ResponseDto<SignInResponseDto> result = authService.signIn(dto);
        return result;
    }
}
