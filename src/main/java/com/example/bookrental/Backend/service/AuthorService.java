package com.example.bookrental.Backend.service;

import com.example.bookrental.Backend.model.dto.AuthorDto;
import com.example.bookrental.Backend.model.entity.Author;
import com.example.bookrental.Backend.model.entity.Country;
import com.example.bookrental.Backend.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;
    private final ICountryService countryService;

    public AuthorService(AuthorRepository authorRepository, ICountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }

    @Override
    public Author addAuthor(AuthorDto authorDto){
        Author author = new Author();
        return saveAuthor(authorDto, author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author editAuthor(Long id, AuthorDto authorDto) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) { return null; }
        return saveAuthor(authorDto, author);
    }

    public List<Author> getAuthorsByCountry(Country country) {
        return authorRepository.findByCountry(country);
    }

    public Author saveAuthor(AuthorDto author, Author a) {
        Country c = countryService.getCountryById(author.getCountry());

        if (c == null) {
            return null;
        }

        a.setName(author.getName());
        a.setSurname(author.getSurname());
        a.setCountry(c);

        return authorRepository.save(a);
    }
}
