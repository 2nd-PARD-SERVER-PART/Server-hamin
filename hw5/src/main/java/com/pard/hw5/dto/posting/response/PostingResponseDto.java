package com.pard.hw5.dto.posting.response;

import com.pard.hw5.dto.user.response.UserResponseDto;
import com.pard.hw5.dto.user.response.UserSimpleResponseDto;
import com.pard.hw5.entity.posting.PostingEntity;
import com.pard.hw5.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostingResponseDto {
    private Long id;
    private String postingName;
    private String postingContent;
    private Timestamp timestamp;
    private UserSimpleResponseDto userResponseDto;

    public PostingResponseDto(PostingEntity posting){
        this.id = posting.getId();
        this.postingName = posting.getPostingName();
        this.postingContent = posting.getPostingContent();
        this.timestamp = posting.getTimestamp();

        if(posting.getUserEntity() != null){
            this.userResponseDto = new UserSimpleResponseDto(posting.getUserEntity());
        }
    }
}
