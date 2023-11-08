package com.pard.hw5.dto.posting.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostingRequestDto {
    private String postingName;
    private String postingContent;
}
