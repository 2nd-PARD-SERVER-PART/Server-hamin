package pard.seminar5th.entity.userLoanHistory;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import pard.seminar5th.repository.userLoanHistoryRepository.UserLoanHistoryRepository;

@Entity
@NoArgsConstructor
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String bookName;

    private boolean isReturn;

    public UserLoanHistory(Long userId, String bookName){
        this.userId = userId;
        this.bookName = bookName;
    }
}
