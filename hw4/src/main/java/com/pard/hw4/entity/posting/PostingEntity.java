package com.pard.hw4.entity.posting;

import com.pard.hw4.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class PostingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String postingTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String postingContent;

    @CreationTimestamp
    private Timestamp postingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_user")
    private UserEntity userEntity;

    @Builder
    public PostingEntity(String postingTitle, String postingContent, UserEntity userEntity){
        this.postingTitle = postingTitle;
        this.postingContent = postingContent;
        this.userEntity = userEntity;
    }

    public void update(String postingTitle, String postingContent){
        if(postingTitle != null && !postingTitle.isEmpty()){
            this.postingTitle = postingTitle;
        }
        if(postingContent != null && !postingContent.isEmpty()){
            this.postingContent = postingContent;
        }
    }
}
