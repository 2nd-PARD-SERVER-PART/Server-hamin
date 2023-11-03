package com.pard.hw4.controller.user;

import com.pard.hw4.dto.response.ResponseDto;
import com.pard.hw4.dto.user.request.UserCreateRequestDto;
import com.pard.hw4.dto.user.request.UserUpdateRequestDto;
import com.pard.hw4.dto.user.response.UserResponseDto;
import com.pard.hw4.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    public final UserService userService;
    @PostMapping("/user")
    public ResponseDto<UserResponseDto> createUser(@RequestBody UserCreateRequestDto request){
        ResponseDto<UserResponseDto> result = userService.save(request);
        return result;
    }

    @GetMapping("/user/{id}")
    public ResponseDto<UserResponseDto> getUser(@PathVariable Long id){
        ResponseDto<UserResponseDto> result = userService.findOne(id);
        return result;
    }

    @GetMapping("/user/all")
    public ResponseDto<List<UserResponseDto>> getAllUser(){
        ResponseDto<List<UserResponseDto>> result = userService.findAll();
        return result;
    }

    @PatchMapping("/user/{id}")
    public ResponseDto<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequestDto request){
        ResponseDto<UserResponseDto> result = userService.update(id, request);
        return result;
    }

    @DeleteMapping("/user/{id}")
    public ResponseDto<?> deleteUser(@PathVariable Long id){
        ResponseDto<?> result = userService.delete(id);
        return result;
    }
}
