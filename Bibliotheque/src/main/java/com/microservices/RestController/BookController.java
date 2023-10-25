package com.microservices.RestController;

import com.microservices.Entities.Book;
import com.microservices.Repositories.BookRepository;
import com.microservices.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliobooks")
public class BookController {


    private final BookService bookService;
    private final BookRepository bookRepository;
    @Autowired
    public BookController(
            BookService bookService, BookRepository bookRepository) {

        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }
    @PostMapping("/addBook")
    public ResponseEntity<Book> AddBook(@RequestBody Book book) {
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/books")
    ResponseEntity<List<Book> >allBooks(){
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);

    }

    @GetMapping("/books/{id}/read")
    public String getBookReader(@RequestParam(required=false) String book) {
        return "books/bibi";
    }
}


