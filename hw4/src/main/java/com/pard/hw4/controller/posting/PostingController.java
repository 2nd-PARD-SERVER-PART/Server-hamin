package com.pard.hw4.controller.posting;

import com.pard.hw4.dto.posting.request.PostingCreateRequestDto;
import com.pard.hw4.dto.posting.request.PostingUpdateRequestDto;
import com.pard.hw4.dto.posting.response.PostingResponseDto;
import com.pard.hw4.dto.response.ResponseDto;
import com.pard.hw4.entity.posting.PostingEntity;
import com.pard.hw4.service.posting.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostingController {
    public final PostingService postingService;

    @PostMapping("/posting")
    public ResponseDto<PostingResponseDto> createPosting(@RequestBody PostingCreateRequestDto request){
        ResponseDto<PostingResponseDto> result = postingService.save(request);
        return result;
    }

    @GetMapping("/posting/{id}")
    public ResponseDto<PostingResponseDto> getPosting(@PathVariable Long id){
        ResponseDto<PostingResponseDto> result = postingService.findOne(id);
        return result;
    }

    @GetMapping("/posting/all")
    public ResponseDto<List<PostingResponseDto>> getAllPosting(){
        ResponseDto<List<PostingResponseDto>> result = postingService.findAll();
        return result;
    }

    @PatchMapping("/posting/{id}")
    public ResponseDto<PostingResponseDto> updatePosting(@PathVariable Long id, @RequestBody PostingUpdateRequestDto request){
        ResponseDto<PostingResponseDto> result = postingService.update(id, request);
        return result;
    }

    @DeleteMapping("/posting/{id}")
    public ResponseDto<?> deletePosting(@PathVariable Long id){
        ResponseDto<?> result = postingService.delete(id);
        return result;
    }
}
