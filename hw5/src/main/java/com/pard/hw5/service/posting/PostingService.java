package com.pard.hw5.service.posting;

import com.pard.hw5.dto.posting.request.PostingRequestDto;
import com.pard.hw5.dto.posting.response.PostingResponseDto;
import com.pard.hw5.dto.response.ResponseDto;
import com.pard.hw5.entity.posting.PostingEntity;
import com.pard.hw5.entity.user.UserEntity;
import com.pard.hw5.repository.posting.PostingRepository;
import com.pard.hw5.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;
    private final UserRepository userRepository;

    public ResponseDto<PostingResponseDto> save(Long userId, PostingRequestDto request){
        String postingName = request.getPostingName();
        String postingContent = request.getPostingContent();
        try{
            UserEntity user = userRepository.findById(userId).get();
            PostingEntity posting = PostingEntity.builder()
                    .postingName(postingName)
                    .postingContent(postingContent)
                    .userEntity(user)
                    .build();
            try{
                postingRepository.save(posting);
                PostingResponseDto result = new PostingResponseDto(posting);
                return ResponseDto.setSuccess("Successfully create posting",result);
            } catch (Exception e){
                e.printStackTrace();
                return ResponseDto.setFailed("DB Error - Failed to create posting.");
            }
        } catch (Exception e){
            return ResponseDto.setFailed("User not found.");
        }
    }

    public ResponseDto<PostingResponseDto> findOne(Long postingId){
        try{
            PostingEntity posting = postingRepository.findById(postingId).get();
            PostingResponseDto result = new PostingResponseDto(posting);
            return ResponseDto.setSuccess("Successfully get posting.",result);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to get posting.");
        }
    }

    public ResponseDto<List<PostingResponseDto>> findAll(){
        try{
            List<PostingResponseDto> postingList = postingRepository.findAll().stream()
                    .map(PostingResponseDto :: new)
                    .collect(Collectors.toList());
            return ResponseDto.setSuccess("Successfully get all posting.",postingList);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to get all posting.");
        }
    }

    @Transactional
    public ResponseDto<PostingResponseDto> update(Long userId, Long postingId, PostingRequestDto request){
        String postingName = request.getPostingName();
        String postingContent = request.getPostingContent();
        try{
            PostingEntity posting = postingRepository.findById(postingId).get();
            UserEntity authorUser = posting.getUserEntity();
            if(authorUser.getId().equals(userId)){
                if(postingName != null && !postingName.isEmpty()){
                    posting.setPostingName(postingName);
                }
                if(postingContent != null && !postingContent.isEmpty()){
                    posting.setPostingContent(postingContent);
                }
                PostingResponseDto result = new PostingResponseDto(posting);
                return ResponseDto.setSuccess("Successfully update posting.",result);
            }
            return ResponseDto.setFailed("Cannot update other user's posting.");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to update posting.");
        }
    }

    public ResponseDto<?> delete(Long userId, Long postingId){
        try{
            PostingEntity posting = postingRepository.findById(postingId).get();
            UserEntity user = posting.getUserEntity();
            if(userId.equals(user.getId())){
                postingRepository.deleteById(postingId);
                return ResponseDto.setSuccess("Successfully delete posting.", null);
            }
            else{
                return ResponseDto.setFailed("Cannot delete other user's posting.");
            }
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error - Failed to delete posting.");
        }
    }
}
