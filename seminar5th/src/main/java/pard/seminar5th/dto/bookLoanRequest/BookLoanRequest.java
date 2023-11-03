package pard.seminar5th.dto.bookLoanRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BookLoanRequest {
    private Long userId;
    private String bookName;
}
