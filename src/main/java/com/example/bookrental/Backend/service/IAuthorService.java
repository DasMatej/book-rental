package com.example.bookrental.Backend.service;


import com.example.bookrental.Backend.model.dto.AuthorDto;
import com.example.bookrental.Backend.model.entity.Author;
import java.util.List;

public interface IAuthorService {
    Author addAuthor(AuthorDto authorDto);
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    void deleteAuthor(Long id);
}