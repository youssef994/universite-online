package com.microservices.Services;

import com.microservices.Entities.Book;
import com.microservices.Entities.Category;
import com.microservices.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Saves a subject.
     *
     * @param category the subject to save
     */
    public void save(Category category) {
        categoryRepository.save(category);
    }

    /**
     * Saves all subjects provided.
     *
     * @param categories the subjects to save
     */
    public void saveAll(List<Category> categories) {
        categoryRepository.saveAll(categories);
    }

    /**
     * Checks if an subject with the provided name exists.
     *
     * @param name the name of the subject
     * @return true if the subject exists, else false
     */
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

    /**
     * Gets a subject based on the provided ID.
     *
     * @param id the ID of the subject
     * @return the subject found
     */
    public Category getById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    /**
     * Gets a subject based on the provided name.
     *
     * @param name the name of the subject
     * @return the subject found
     */
    public Category getByName(String name) {
        return categoryRepository.getByName(name);
    }

    /**
     * Gets a list of subjects based on the provided name.
     *
     * @param name the name to use as a search term
     * @param sort the sort order for the results
     * @return the subjects found
     */
    public List<Category> getSubjectsByNameIsContainingIgnoreCase(String name, Sort sort) {
        return categoryRepository.getSubjectsByNameIsContainingIgnoreCase(name, sort);
    }

    /**
     * Gets a random subject.
     *
     * @return the subject found
     */
    public Category getByRandom() {
        List<Category> categories = categoryRepository.findAll();
        Random random = new Random();
        return categories.get(random.nextInt(categories.size()));
    }

    /**
     * Finds all subjects.
     *
     * @return the subjects found
     */
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * Adds a book to a subject's list of books if not already present.
     *
     * @param category the subject to save
     * @param book the book to save to the subject
     */
    public void mapToBook(Category category, Book book) {
        List<Book> books = category.getBooks();
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

       category.setBooks(books);
        categoryRepository.save(category);
    }

}
