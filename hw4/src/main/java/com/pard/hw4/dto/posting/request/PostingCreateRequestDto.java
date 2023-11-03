package com.pard.hw4.dto.posting.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostingCreateRequestDto {
    private String postingTitle;
    private String postingContent;
    private Long authorUserId;
}
