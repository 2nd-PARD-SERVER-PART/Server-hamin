package com.pard.hw5.entity.user;

import com.pard.hw5.dto.signUp.requset.SignUpRequestDto;
import com.pard.hw5.entity.posting.PostingEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String userName;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String userEmail;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String hashedPassword;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostingEntity> postingList = new ArrayList<>();

    @CreationTimestamp
    private Timestamp signUpDate;

    @Builder
    public UserEntity(String userName, String userEmail, String hashedPassword){
        this.userName = userName;
        this.userEmail = userEmail;
        this.hashedPassword = hashedPassword;
    }

    public UserEntity(SignUpRequestDto dto){
        this.userName = dto.getUserName();
        this.userEmail = dto.getUserEmail();
        this.hashedPassword = dto.getUserPassword();
    }
}
