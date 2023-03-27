package com.example.bookrental.Backend.dataInit;

import com.example.bookrental.Backend.model.entity.Author;
import com.example.bookrental.Backend.model.entity.Book;
import com.example.bookrental.Backend.model.entity.Country;
import com.example.bookrental.Backend.model.enums.BookCategory;
import com.example.bookrental.Backend.repository.AuthorRepository;
import com.example.bookrental.Backend.repository.BookRepository;
import com.example.bookrental.Backend.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInit {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInit(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        if (countryRepository.count() != 0 || authorRepository.count() != 0 || bookRepository.count() != 0) {
            return;
        }
        for (int i = 1; i < 10; i++) {
            createFake(i);
        }
    }

    private void createFake(int i) {
        Country c = new Country();
        c.setName(String.format("Country %d", i));
        c.setContinent(String.format("Continent %d", i));
        countryRepository.save(c);

        Author a = new Author();
        a.setName(String.format("Name %d", i));
        a.setSurname(String.format("Surname %d", i));
        a.setCountry(c);
        authorRepository.save(a);

        Book b = new Book();
        b.setName(String.format("Name %d", i));
        b.setCategory(BookCategory.values()[i % BookCategory.values().length]);
        b.setAuthor(a);
        b.setAvailableCopies(i);
        bookRepository.save(b);
    }
}
