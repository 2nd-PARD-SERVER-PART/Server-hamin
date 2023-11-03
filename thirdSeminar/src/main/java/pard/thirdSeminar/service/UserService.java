package pard.thirdSeminar.service;

import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pard.thirdSeminar.dto.ResponseDto;
import pard.thirdSeminar.dto.SignInDto;
import pard.thirdSeminar.dto.SignUpDto;
import pard.thirdSeminar.entity.UserEntity;
import pard.thirdSeminar.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseDto<UserEntity> signup(SignUpDto dto){
        UserEntity user = new UserEntity(dto);
        String userEmail = dto.getUserEmail();
        try {
            if(userRepository.existsByUserEmail(userEmail)){
                return ResponseDto.setFailed("User already exist");
            }
            userRepository.save(user);
            return ResponseDto.setSuccess("success",user);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }

    public ResponseDto<List<UserEntity>> findAll(){
        List<UserEntity> users;
        try {
            users = userRepository.findAll();
            return ResponseDto.setSuccess("find Success", users);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed(("DB Error"));
        }
    }

    public ResponseDto<UserEntity> findOne(Integer userNum){
        UserEntity user;
        try{
            user = userRepository.findById(userNum).get();
            return ResponseDto.setSuccess("success",user);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }

    @Transactional
    public ResponseDto<UserEntity> update(Integer userNum, SignUpDto dto){
        UserEntity user;
        try{
            user = userRepository.findById(userNum).get();
            if(dto.getUserEmail() != null && !dto.getUserEmail().isEmpty())user.setUserEmail(dto.getUserEmail());
            if(dto.getUserPassword() != null && !dto.getUserPassword().isEmpty())user.setUserPassword(dto.getUserPassword());
            return ResponseDto.setSuccess("success",user);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }

    public ResponseDto<?> delete(Integer userNum){
        try{
            if(userRepository.existsById(userNum)){
                userRepository.deleteById(userNum);
                return ResponseDto.setSuccess("success", null);
            }
            return ResponseDto.setFailed("id not exist");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }

    public ResponseDto<String> signIn(SignInDto dto){
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        boolean existed = userRepository.existsByUserEmailAndUserPassword(userEmail, userPassword);
        if(!existed){
            return ResponseDto.setFailed("user not exist");
        }
        return ResponseDto.setSuccess("login", userEmail);
    }
}
