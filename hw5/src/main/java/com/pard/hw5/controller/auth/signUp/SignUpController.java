package com.pard.hw5.controller.auth.signUp;

import com.pard.hw5.dto.response.ResponseDto;
import com.pard.hw5.dto.signUp.requset.SignUpRequestDto;
import com.pard.hw5.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class SignUpController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseDto<?> signUp(@RequestBody SignUpRequestDto dto){
        ResponseDto<?> result = authService.signUp(dto);
        return result;
    }

}
