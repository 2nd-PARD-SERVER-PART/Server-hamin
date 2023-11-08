package com.pard.hw5.controller.user;

import com.pard.hw5.dto.response.ResponseDto;
import com.pard.hw5.dto.user.request.UserUpdateRequestDto;
import com.pard.hw5.dto.user.response.UserResponseDto;
import com.pard.hw5.filter.JwtAuthenticationFilter;
import com.pard.hw5.security.TokenProvider;
import com.pard.hw5.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserService userService;

    @GetMapping("/user/{id}")
    public ResponseDto<UserResponseDto> getUser(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){
        String userId = tokenProvider.validate(token.substring(7));
        String strId = id.toString();
        if(strId != null && !strId.isEmpty()){
            if(strId.equals(userId)){
                ResponseDto<UserResponseDto> result = userService.findOne(id);
                return result;
            }
            else {
                return ResponseDto.setFailed("Authorize Error - Id not correct");
            }
        }
        else{
            return ResponseDto.setFailed("Id is empty.");
        }
    }

    @GetMapping("/user/all")
    public ResponseDto<List<UserResponseDto>> getUser(@RequestHeader(value = "Authorization") String token){
        String userId = tokenProvider.validate(token.substring(7));
        ResponseDto<List<UserResponseDto>> result = userService.findAll();
        return result;
    }

    @PatchMapping("/user/{id}")
    public ResponseDto<UserResponseDto> updateUser(@RequestHeader(value = "Authorization") String token, @PathVariable Long id, @RequestBody UserUpdateRequestDto request){
        String userId = tokenProvider.validate(token.substring(7));
        String strId = id.toString();
        if(strId != null && !strId.isEmpty()){
            if(strId.equals(userId)){
                ResponseDto<UserResponseDto> result = userService.update(id, request);
                return result;
            }
            else {
                return ResponseDto.setFailed("Authorize Error - Id not correct");
            }
        }
        else{
            return ResponseDto.setFailed("Id is empty.");
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseDto<?> deleteUser(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){
        String userId = tokenProvider.validate(token.substring(7));
        String strId = id.toString();
        if(strId != null && !strId.isEmpty()){
            if(strId.equals(userId)){
                ResponseDto<?> result = userService.delete(id);
                return result;
            }
            else {
                return ResponseDto.setFailed("Authorize Error - Id not correct");
            }
        }
        else{
            return ResponseDto.setFailed("Id is empty.");
        }
    }
}
