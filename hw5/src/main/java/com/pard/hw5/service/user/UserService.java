package com.pard.hw5.service.user;

import com.pard.hw5.config.WebSecurityConfig;
import com.pard.hw5.dto.response.ResponseDto;
import com.pard.hw5.dto.user.request.UserUpdateRequestDto;
import com.pard.hw5.dto.user.response.UserResponseDto;
import com.pard.hw5.entity.user.UserEntity;
import com.pard.hw5.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final WebSecurityConfig webSecurityConfig;

    public ResponseDto<UserResponseDto> findOne(Long id){
        if(!userRepository.existsById(id)){
            return ResponseDto.setFailed("User not exist.");
        }
        try{
            UserEntity user = userRepository.findById(id).get();
            UserResponseDto result = new UserResponseDto(user);
            return ResponseDto.setSuccess("Successfully get user.", result);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to get user info.");
        }
    }

    public ResponseDto<List<UserResponseDto>> findAll(){
        try{
            List<UserResponseDto> userList = userRepository.findAll().stream()
                    .map(UserResponseDto :: new)
                    .collect(Collectors.toList());
            return ResponseDto.setSuccess("Successfully get all user.",userList);
        } catch (Exception e){
            return ResponseDto.setFailed("DB Error - Failed to get all user");
        }
    }

    @Transactional
    public ResponseDto<UserResponseDto> update(Long id, UserUpdateRequestDto request){
        if(!userRepository.existsById(id)){
            return ResponseDto.setFailed("User not exist.");
        }
        if(userRepository.existsByUserEmail(request.getUserEmail())){
            return ResponseDto.setFailed("Email already exist.");
        }

        try{
            UserEntity user = userRepository.findById(id).get();
            if(request.getUserName() != null && !request.getUserName().isEmpty()){
                String userName = request.getUserName();
                user.setUserName(userName);
            }
            if(request.getUserEmail() != null && !request.getUserEmail().isEmpty()){
                String userEmail = request.getUserEmail();
                user.setUserEmail(userEmail);
            }
            if(request.getUserPassword() != null && !request.getUserPassword().isEmpty()){
                String hashedPassword = webSecurityConfig.getPasswordEncoder().encode(request.getUserPassword());
                user.setHashedPassword(hashedPassword);
            }
            UserResponseDto result = new UserResponseDto(user);
            return ResponseDto.setSuccess("Successfully update user.",result);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to update user.");
        }
    }

    public ResponseDto<?> delete(Long id){
        if(!userRepository.existsById(id)){
            return ResponseDto.setFailed("User not exist.");
        }
        try {
            userRepository.deleteById(id);
            return ResponseDto.setSuccess("Successfully delete user.", null);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to delete user in DB.");
        }
    }
}
