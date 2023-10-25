package com.microservices.RestController;

import com.microservices.Entities.Author;
import com.microservices.Entities.Book;
import com.microservices.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioauthor")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorService authorRepository;

    @Autowired
    public AuthorController(
            AuthorService authorService, AuthorService authorRepository) {

        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }
    @PostMapping("/addAuthor")
    public ResponseEntity AddAuthor(@RequestBody Author author) {
         authorService.save(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/Authors")
    public ResponseEntity<List<Author>> showAllAuthor() {
        List<Author> authors = authorRepository.findAll();

        if (authors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor( @PathVariable Integer id) {
        Author author = authorService.getById(id);

        return author;
    }
    @PostMapping("/CreateandAddBookandAuthaur")
    public ResponseEntity addStudentWithClass(@RequestBody Author author, @RequestBody Book book) {
        authorService.mapToBook(author,book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
