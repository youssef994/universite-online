package com.microservices.Services;

import com.microservices.Entities.Author;
import com.microservices.Entities.Book;
import com.microservices.Repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private final AutorRepository authorRepository;

    @Autowired
    public AuthorService(AutorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void save(Author author) {
        authorRepository.save(author);
    }


    public Author getById(Integer id) {
        return authorRepository.findById(id).get();

    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    public Author getByRandom() {
        List<Author> authors = authorRepository.findAll();
        Random random = new Random();
        return authors.get(random.nextInt(authors.size()));
    }

    public void mapToBook(Author author, Book book) {
        List<Book> books = author.getBooks();
        boolean alreadyPresent = false;

        if (books == null) {
            books = new ArrayList<>();
        }

        for (Book b : books) {
            if (b.getName().equals(book.getName())) {
                alreadyPresent = true;
                break;
            }
        }

        if (!alreadyPresent) {
            books.add(book);
        }

        author.setBooks(books);
        authorRepository.save(author);
    }
    public List<Author> getAuthorsByNameIsContainingIgnoreCase(String name, Sort sort) {
        return authorRepository.getAuthorsByNameIsContainingIgnoreCase(name, sort);
    }


}
