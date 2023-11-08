package com.pard.hw5.entity.posting;

import com.pard.hw5.dto.posting.request.PostingRequestDto;
import com.pard.hw5.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String postingName;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String postingContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_user")
    private UserEntity userEntity;

    @CreationTimestamp
    private Timestamp timestamp;

    @Builder
    public PostingEntity(String postingName, String postingContent, UserEntity userEntity){
        this.postingName = postingName;
        this.postingContent = postingContent;
        this.userEntity = userEntity;
    }

}
