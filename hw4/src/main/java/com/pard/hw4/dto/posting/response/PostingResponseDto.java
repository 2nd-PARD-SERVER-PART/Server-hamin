package com.pard.hw4.dto.posting.response;

import com.pard.hw4.dto.user.response.UserResponseDto;
import com.pard.hw4.entity.posting.PostingEntity;
import com.pard.hw4.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostingResponseDto {
    private Long id;
    private String postingTitle;
    private String postingContent;
    private Timestamp postingDate;
    private UserResponseDto userResponseDto;



    public PostingResponseDto(PostingEntity postingEntity){
        this.id = postingEntity.getId();
        this.postingTitle = postingEntity.getPostingTitle();
        this.postingContent = postingEntity.getPostingContent();
        this.postingDate = postingEntity.getPostingDate();
        if(postingEntity.getUserEntity() != null){
            this.userResponseDto = new UserResponseDto(postingEntity.getUserEntity());
        }
    }
}
