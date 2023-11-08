package com.pard.hw5.dto.posting.response;

import com.pard.hw5.entity.posting.PostingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostingSimpleResponseDto {
    private Long id;
    private String postingName;
    private Timestamp postingUploadDate;

    public PostingSimpleResponseDto(PostingEntity posting){
        this.id = posting.getId();
        this.postingName = posting.getPostingName();
        this.postingUploadDate = posting.getTimestamp();
    }
}
