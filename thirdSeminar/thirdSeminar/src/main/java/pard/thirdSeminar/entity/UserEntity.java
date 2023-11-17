package pard.thirdSeminar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.stereotype.Controller;
import pard.thirdSeminar.dto.SignUpDto;

import java.sql.Timestamp;

@Entity
@Data //!!!!
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNum;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String userEmail; //user_email
    @Column(length = 20)
    private String userPassword; //user_password

    @CreationTimestamp
    private Timestamp userSignUptime;

    public UserEntity(SignUpDto dto){
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
    }
}
