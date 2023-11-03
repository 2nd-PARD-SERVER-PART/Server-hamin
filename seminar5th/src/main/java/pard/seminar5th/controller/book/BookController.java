package pard.seminar5th.controller.book;

import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pard.seminar5th.dto.book.BookCreateRequest;
import pard.seminar5th.dto.bookLoanRequest.BookLoanRequest;
import pard.seminar5th.service.book.BookService;

@RestController
@Slf4j
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request){
        bookService.saveBook(request);
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request){
        bookService.loanBook(request);
    }
}
