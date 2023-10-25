package com.microservices.Services;

import com.microservices.Entities.Book;
import com.microservices.Repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Saves a book.
     *
     * @param book the book to save
     */
    public void save(Book book) {
        bookRepository.save(book);
    }
    /**
     * Saves all books provided.
     *
     * @param books the books to save
     */
    public void saveAll(List<Book> books) {
        bookRepository.saveAll(books);
    }
    /**
     * Checks if a book with the provided name exists.
     *
     * @param name the name of the book
     * @return true if the book exists, else false
     */
    public boolean existsByName(String name) {
        return bookRepository.existsByName(name);
    }

    /**
     * Gets a book based on the provided ID.
     *
     * @param id the ID of the book
     * @return the book found
     */
    public Book getById(Integer id) {
        return bookRepository.findById(id).get();
    }
    /**
     * Gets a book based on the provided name.
     *
     * @param name the name of the book
     * @return the book found
     */
    public Book getByName(String name) {
        return bookRepository.getByName(name);
    }
    /**
     * Gets a list of books based on the provided name.
     *
     * @param name the name to use as a search term
     * @param sort the sort order for the results
     * @return the books found
     */
    public List<Book> getBooksByNameIsContainingIgnoreCase(String name, Sort sort) {
        return bookRepository.getBooksByNameIsContainingIgnoreCase(name, sort);
    }
    /**
     * Gets a random book.
     *
     * @return the book found
     */
    public Book getByRandom() {
        List<Book> books = bookRepository.findAll();
        Random random = new Random();
        return books.get(random.nextInt(books.size()));
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book updateBook(Integer id,Book b) {

        return bookRepository.findById(id)
                .map(a -> {
                    a.setName(b.getName());


                    return bookRepository.save(b);
                }).orElseThrow(() -> new RuntimeException("book not found !"));
    }

}
