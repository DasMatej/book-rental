package com.example.bookrental.Backend.service;

import com.example.bookrental.Backend.model.dto.BookDto;
import com.example.bookrental.Backend.model.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book saveBook(Book book);
    void deleteBook(Long id);
    Book rentBook(Long id);
    Book returnBook(Long id);

    Book addBook(BookDto book);

}
