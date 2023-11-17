package protect.pard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import protect.pard.config.WebSecurityConfig;
import protect.pard.dto.ResponseDto;
import protect.pard.dto.SignInDto;
import protect.pard.dto.SignInResponseDto;
import protect.pard.dto.SignUpDto;
import protect.pard.entity.UserEntity;
import protect.pard.repository.UserRepository;
import protect.pard.security.TokenProvider;

@Service
public class AuthService {
    private UserRepository userRepository;
    private TokenProvider tokenProvider;
    private WebSecurityConfig webSecurityConfig;

    @Autowired
    public AuthService(UserRepository userRepository, TokenProvider tokenProvider, WebSecurityConfig webSecurityConfig){
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
        this.webSecurityConfig = webSecurityConfig;
    }

    public ResponseDto<?> signUp(SignUpDto dto){
        String userEmail = dto.getUserEmail();
        String userPassword = webSecurityConfig.getPasswordEncoder().encode(dto.getUserPassword());
        SignUpDto putDto = new SignUpDto(userEmail, userPassword);
        try{
            if(userRepository.existsById(userEmail)){
                return ResponseDto.setFailed("user email is exist.");
            }
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
        UserEntity userEntity = new UserEntity(putDto);

        userRepository.save(userEntity);
        return ResponseDto.setSuccess("Sign UP success", userEntity);
    }
    public ResponseDto<SignInResponseDto> signIn(SignInDto dto){
        String userEmail = dto.getUserEmail();
        UserEntity user = userRepository.findById(userEmail).get();
        boolean passwordMatch = webSecurityConfig.getPasswordEncoder().matches(dto.getUserPassword(), user.getUserPassword());
        boolean existed = userRepository.existsById(userEmail) && passwordMatch;
        if(!existed) return ResponseDto.setFailed("Email or password not correct");
        user.setUserPassword("");

        String token = tokenProvider.create(userEmail);
        int exprTime = 360000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, user);
        return ResponseDto.setSuccess("Login success",signInResponseDto);
    }
}
