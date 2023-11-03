package com.pard.hw4.entity.user;

import com.pard.hw4.entity.posting.PostingEntity;
import jakarta.persistence.*;
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
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String email;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String password;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostingEntity> postingList = new ArrayList<>();

    @CreationTimestamp
    private Timestamp signUpDate;

    @Builder
    public UserEntity(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void update(String name, String email, String password){
        if(name != null && !name.isEmpty()){
            this.name = name;
        }
        if(email != null && !email.isEmpty()){
            this.email = email;
        }
        if(password != null && !password.isEmpty()){
            this.password = password;
        }
    }

}
