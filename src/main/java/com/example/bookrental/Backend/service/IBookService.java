package com.example.bookrental.Backend.service;

import com.example.bookrental.Backend.model.dto.BookDto;
import com.example.bookrental.Backend.model.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void deleteBook(Long id);
    Book editBook(Long id, BookDto book);
    void markBookAsTaken(Long id);
    Book addBook(BookDto book);
    List<Book> getBooksByAuthorId(Long id);
}
