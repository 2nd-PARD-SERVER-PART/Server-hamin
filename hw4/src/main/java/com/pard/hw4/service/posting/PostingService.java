package com.pard.hw4.service.posting;

import com.pard.hw4.dto.posting.request.PostingCreateRequestDto;
import com.pard.hw4.dto.posting.request.PostingUpdateRequestDto;
import com.pard.hw4.dto.posting.response.PostingResponseDto;
import com.pard.hw4.dto.response.ResponseDto;
import com.pard.hw4.entity.posting.PostingEntity;
import com.pard.hw4.entity.user.UserEntity;
import com.pard.hw4.repository.posting.PostingRepository;
import com.pard.hw4.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostingService {
    public final PostingRepository postingRepository;
    public final UserRepository userRepository;

    public ResponseDto<PostingResponseDto> save(PostingCreateRequestDto request){
        try {
            UserEntity user = userRepository.findById(request.getAuthorUserId()).get();
            PostingEntity targetPosting = new PostingEntity(request.getPostingTitle(), request.getPostingContent(), user);
            PostingEntity uploadedPosting = postingRepository.save(targetPosting);
            PostingResponseDto result = new PostingResponseDto(uploadedPosting);
            return ResponseDto.setSuccess("success", result);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to save posting.");
        }
    }

    public ResponseDto<PostingResponseDto> findOne(Long id){
        try {
            PostingEntity posting = postingRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Posting not exist."));
            return ResponseDto.setSuccess("success", new PostingResponseDto(posting));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to find posting");
        }
    }

    public ResponseDto<List<PostingResponseDto>> findAll(){
        try {
            List<PostingResponseDto> result = postingRepository.findAll()
                    .stream()
                    .map(PostingResponseDto :: new)
                    .toList();
            return ResponseDto.setSuccess("success", result);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to find all posting");
        }
    }

    @Transactional
    public ResponseDto<PostingResponseDto> update(Long id, PostingUpdateRequestDto request){
        try {
            PostingEntity posting = postingRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Posting not exist."));
            if(request.getPostingTitle() != null && !request.getPostingTitle().isEmpty()){
                posting.setPostingTitle(request.getPostingTitle());
            }
            if(request.getPostingContent() != null && !request.getPostingContent().isEmpty()){
                posting.setPostingContent(request.getPostingContent());
            }
            PostingResponseDto result = new PostingResponseDto(posting);
            return ResponseDto.setSuccess("success",result);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to update posting");
        }
    }

    @Transactional
    public ResponseDto<?> delete(Long id){
        try{
            if(postingRepository.existsById(id)){
                postingRepository.deleteById(id);
            }
            return ResponseDto.setSuccess("success",null);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to delete posting.");
        }
    }
}
