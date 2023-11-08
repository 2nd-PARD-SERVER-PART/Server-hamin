package com.pard.hw5.dto.user.response;

import com.pard.hw5.dto.posting.response.PostingSimpleResponseDto;
import com.pard.hw5.entity.posting.PostingEntity;
import com.pard.hw5.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String userName;
    private String userEmail;
    private List<PostingSimpleResponseDto> postingList;
    private Timestamp signUpDate;

    public UserResponseDto(UserEntity user){
        this.id = user.getId();
        this.userName = user.getUserName();
        this.userEmail = user.getUserEmail();
        if(user.getPostingList() != null){
            this.postingList = user.getPostingList().stream()
                    .map(PostingSimpleResponseDto::new)
                    .collect(Collectors.toList());
        }
        this.signUpDate = user.getSignUpDate();
    }
}
