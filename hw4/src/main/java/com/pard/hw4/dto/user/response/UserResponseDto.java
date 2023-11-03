package com.pard.hw4.dto.user.response;

import com.pard.hw4.dto.posting.response.PostingSimpleResponseDto;
import com.pard.hw4.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private List<PostingSimpleResponseDto> postingList;

    public UserResponseDto(UserEntity userEntity){
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();

        if(userEntity.getPostingList() != null){
            this.postingList = userEntity.getPostingList().stream()
                    .map(PostingSimpleResponseDto::new)
                    .collect(Collectors.toList());
        }
    }
}
