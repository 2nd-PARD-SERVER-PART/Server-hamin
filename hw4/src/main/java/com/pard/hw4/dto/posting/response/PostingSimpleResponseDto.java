package com.pard.hw4.dto.posting.response;

import com.pard.hw4.entity.posting.PostingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostingSimpleResponseDto {
    private Long id;
    private String postingTitle;
    private Timestamp postingDate;

    public PostingSimpleResponseDto(PostingEntity postingEntity){
        this.id = postingEntity.getId();
        this.postingTitle = postingEntity.getPostingTitle();
        this.postingDate = postingEntity.getPostingDate();
    }
}
