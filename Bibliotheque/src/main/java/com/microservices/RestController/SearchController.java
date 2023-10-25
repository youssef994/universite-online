package com.microservices.RestController;

import com.microservices.Entities.Category;
import com.microservices.Services.SearchService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SessionAttributes({"resultsPerPage"})
@RequestMapping("/biblio")
@RestController
public class SearchController {

    private final SearchService searchService;
    @Autowired
    public SearchController(SearchService searchService
                           ) {
        this.searchService = searchService;

    }

    @GetMapping("/search")
    public String getSearch(Model model,
                            HttpServletRequest request,
                            @RequestParam(required=false) String terms,
                            @RequestParam(required=false) String filter,
                            @RequestParam(required=false) String order,
                            @RequestParam(required=false) Integer page) {

        Integer resultsPerPage = (Integer) model.getAttribute("resultsPerPage");

        if (resultsPerPage == null) {
            resultsPerPage = 0;
        }

        if (filter == null) {
            filter = "books";
        }

        if (terms == null) {
            terms = "";
        }

        if (order == null || !order.equals("desc")) {
            order = "asc";
        }

        if (page == null || page < 1) {
            page = 1;
        }

        String entry = String.format("Get %s results from page %s of %s for '%s' ordered %s",
                resultsPerPage, page, filter,  terms, order);


        List<?> results = searchService.getSearchResults(terms, filter, order);
        int resultCount = results.size();
        int lastPage = searchService.getLastPageNumber(resultCount, resultsPerPage);

        if (page > lastPage) {
            page = lastPage;
        }
        List<String> resultPages = searchService.getPageNumbers(resultCount, page, resultsPerPage);
        results = searchService.limitResultsByPage(results, page, resultsPerPage);
        String currentUrl = request.getContextPath();
        String parameters = request.getQueryString();

        if (parameters != null ) {
            parameters = parameters.replaceAll("[&]*page=[-+]*[0-9]*", "");

            if (parameters.length() != 0) {
                currentUrl += "?" + parameters;
            }
        }




        return null;
    }
}

