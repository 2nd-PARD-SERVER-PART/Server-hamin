package com.pard.hw4.service.user;

import com.pard.hw4.dto.response.ResponseDto;
import com.pard.hw4.dto.user.request.UserCreateRequestDto;
import com.pard.hw4.dto.user.request.UserUpdateRequestDto;
import com.pard.hw4.dto.user.response.UserResponseDto;
import com.pard.hw4.entity.user.UserEntity;
import com.pard.hw4.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public ResponseDto<UserResponseDto> save(UserCreateRequestDto request){
        try {
            UserEntity userEntity = userRepository.save(request.toEntity());
            UserResponseDto user = new UserResponseDto(userEntity);
            return ResponseDto.setSuccess("success",user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to save user information on DB.");
        }
    }

    public ResponseDto<UserResponseDto> findOne(Long id){
        try {
            UserEntity userEntity = userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Posting not exist."));
            UserResponseDto user = new UserResponseDto(userEntity);
            return ResponseDto.setSuccess("success", user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to get user information from DB.");
        }
    }

    public ResponseDto<List<UserResponseDto>> findAll(){
        List<UserEntity> userEntities;
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        try{
            userEntities = userRepository.findAll();
            for(int i = 0; i < userEntities.size(); i++){
                userResponseDtos.add(new UserResponseDto(userEntities.get(i)));
            }
            return ResponseDto.setSuccess("success", userResponseDtos);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to get all user information from DB.");
        }
    }

    @Transactional
    public ResponseDto<UserResponseDto> update(Long id, UserUpdateRequestDto request){
        try{
            UserEntity userEntity = userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Posting not exist."));
            if(request.getName() != null && !request.getName().isEmpty()){
                userEntity.setName(request.getName());
            }
            if(request.getEmail() != null && !request.getEmail().isEmpty()){
                userEntity.setEmail(request.getEmail());
            }
            if(request.getPassword() != null && !request.getPassword().isEmpty()){
                userEntity.setPassword(request.getPassword());
            }
            UserResponseDto user = new UserResponseDto(userEntity);
            return ResponseDto.setSuccess("success",user);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to update user information on DB.");
        }
    }

    @Transactional
    public ResponseDto<?> delete(Long id){
        try{
            if(userRepository.existsById(id)){
                userRepository.deleteById(id);
                return ResponseDto.setSuccess("success",null);
            }
            else{
                return ResponseDto.setFailed("Value Error - Id is not exist.");
            }
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to delete user from DB.");
        }
    }


}
