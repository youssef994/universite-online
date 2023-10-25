package com.microservices.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class SearchService {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;
    @Autowired
    public SearchService(
                         AuthorService authorService,
                         BookService bookService,
                         CategoryService categoryService
                        ) {

        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;}


        public List<?> getSearchResults(String terms, String filter, String order) {
            filter = filter.replace("list", "catalog"); // usage of "list" is for front end only
            Sort.Direction sortDirection = "desc".equals(order.toLowerCase()) ? Sort.Direction.DESC : Sort.Direction.ASC;
            Sort sort = Sort.by(sortDirection, "name");

            switch (filter) {
                case "authors":
                    return authorService.getAuthorsByNameIsContainingIgnoreCase(terms, sort);
                case "categories":
                    return categoryService.getSubjectsByNameIsContainingIgnoreCase(terms, sort);
                case "Books":

                    return bookService.getBooksByNameIsContainingIgnoreCase(terms, sort);
                default:
                    return bookService.getBooksByNameIsContainingIgnoreCase(terms, sort);
            }

        }

    public Integer getLastPageNumber(int resultCount, int resultsPerPage) {
        int lastPage = resultCount / resultsPerPage;

        if (resultCount % resultsPerPage != 0) {
            lastPage++;
        }

        return lastPage;
    }
    public List<String> getPageNumbers(int resultCount, int currentPage, int resultsPerPage) {
        List<String> resultPages = new ArrayList<>();
        int lastPage = getLastPageNumber(resultCount, resultsPerPage);
        int pageCounter = 0;

        while (++pageCounter <= lastPage) {
            if  (
                    pageCounter <= 3 || // First three pages
                            pageCounter >= lastPage - 2 || // Last three pages
                            // Up to five pages around and including the current page
                            (pageCounter >= currentPage - 2 && pageCounter <= currentPage + 2)
            ) {
                resultPages.add(String.valueOf(pageCounter));
            }
            else if (
                    pageCounter == currentPage - 3 ||
                            pageCounter == currentPage + 3
            ) {
                resultPages.add("...");
            }
        }

        return resultPages;
    }

    public List<?> limitResultsByPage(List<?> results, int page, int resultsPerPage) {
        if (results.isEmpty()) {
            return results;
        }

        int fromIndex = page * resultsPerPage - resultsPerPage;

        if (fromIndex < 0) {
            fromIndex = 0;
        }

        if (fromIndex > results.size()) {
            fromIndex = results.size();
        }

        int toIndex = fromIndex + resultsPerPage;

        if (toIndex > results.size()) {
            toIndex = results.size();
        }

        return results.subList(fromIndex, toIndex);
    }

}




