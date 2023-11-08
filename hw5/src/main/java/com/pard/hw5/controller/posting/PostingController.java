package com.pard.hw5.controller.posting;

import com.pard.hw5.dto.posting.request.PostingRequestDto;
import com.pard.hw5.dto.posting.response.PostingResponseDto;
import com.pard.hw5.dto.response.ResponseDto;
import com.pard.hw5.security.TokenProvider;
import com.pard.hw5.service.posting.PostingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class PostingController {
    private final PostingService postingService;
    private final TokenProvider tokenProvider;

    @PostMapping("/posting")
    public ResponseDto<PostingResponseDto> createPosting(@RequestHeader(value = "Authorization") String token, @RequestBody PostingRequestDto request){
        String userId = tokenProvider.validate(token.substring(7));
        Long id = Long.parseLong(userId);
        ResponseDto<PostingResponseDto> result = postingService.save(id, request);
        return result;
    }

    @GetMapping("/posting/{postingId}")
    public ResponseDto<PostingResponseDto> getPosting(@RequestHeader(value = "Authorization") String token, @PathVariable Long postingId){
        String userId = tokenProvider.validate(token.substring(7));
        ResponseDto<PostingResponseDto> result = postingService.findOne(postingId);
        return result;
    }

    @GetMapping("/posting/all")
    public ResponseDto<List<PostingResponseDto>> getAllPosting(@RequestHeader(value = "Authorization") String token){
        String userId = tokenProvider.validate(token.substring(7));
        ResponseDto<List<PostingResponseDto>> result = postingService.findAll();
        return result;
    }

    @PatchMapping("/posting/{postingId}")
    public ResponseDto<PostingResponseDto> updatePosting(@RequestHeader(value = "Authorization") String token, @PathVariable Long postingId, @RequestBody PostingRequestDto request){
        String userId = tokenProvider.validate(token.substring(7));
        Long id = Long.parseLong(userId);
        ResponseDto<PostingResponseDto> result = postingService.update(id, postingId, request);
        return result;
    }

    @DeleteMapping("/posting/{postingId}")
    public ResponseDto<?> deletePosting(@RequestHeader(value = "Authorization") String token, @PathVariable Long postingId){
        String userId = tokenProvider.validate(token.substring(7));
        Long id = Long.parseLong(userId);
        ResponseDto<?> result = postingService.delete(id, postingId);
        return result;
    }
}
