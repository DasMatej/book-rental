package com.example.bookrental.Backend.controller;

import com.example.bookrental.Backend.model.dto.CountryDto;
import com.example.bookrental.Backend.model.entity.Author;
import com.example.bookrental.Backend.model.entity.Book;
import com.example.bookrental.Backend.model.entity.Country;
import com.example.bookrental.Backend.service.IAuthorService;
import com.example.bookrental.Backend.service.IBookService;
import com.example.bookrental.Backend.service.ICountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final ICountryService countryService;
    private final IAuthorService authorService;
    private final IBookService bookService;

    public CountryController(ICountryService countryService, IAuthorService authorService, IBookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/allCountries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Country country = countryService.getCountryById(id);
        if (country == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(country);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody CountryDto country) {
        Country newCountry = countryService.addCountry(country);
        if (newCountry == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newCountry);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable Long id, @RequestBody CountryDto country) {
        Country newCountry = countryService.editCountry(id, country);
        if (newCountry == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newCountry);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id) {
        Country country = countryService.getCountryById(id);
        if (country == null) {
            return ResponseEntity.notFound().build();
        } else {

            List<Author> authors = authorService.getAuthorsByCountry(country);
            for (Author author : authors) {
                authorService.deleteAuthor(author.getId());
            }

            List<Book> books = bookService.getBooksByCountry(country);
            for (Book book : books) {
                bookService.deleteBook(book.getId());
            }

            countryService.deleteCountry(id);
            return ResponseEntity.ok().build();
        }
    }
}