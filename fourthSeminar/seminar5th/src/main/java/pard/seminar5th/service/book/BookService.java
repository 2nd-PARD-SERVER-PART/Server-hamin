package pard.seminar5th.service.book;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pard.seminar5th.dto.book.BookCreateRequest;
import pard.seminar5th.dto.bookLoanRequest.BookLoanRequest;
import pard.seminar5th.entity.book.Book;
import pard.seminar5th.entity.user.User;
import pard.seminar5th.entity.userLoanHistory.UserLoanHistory;
import pard.seminar5th.repository.book.BookRepository;
import pard.seminar5th.repository.user.UserRepository;
import pard.seminar5th.repository.userLoanHistoryRepository.UserLoanHistoryRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    // UserLoanHistoryRepository에 접근 해야하니까 의존성 주입
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService (BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository){
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request){
        Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalArgumentException::new);
        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(request.getBookName(), false)){
            throw new IllegalArgumentException("이미 대출 된 책 입니다.");
        }

        User user = userRepository.findById(request.getUserId()).orElseThrow(IllegalArgumentException::new);
        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), book.getName()));
    }
}
