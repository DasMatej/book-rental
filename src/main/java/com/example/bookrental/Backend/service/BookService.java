package com.example.bookrental.Backend.service;

import com.example.bookrental.Backend.model.dto.BookDto;
import com.example.bookrental.Backend.model.entity.Author;
import com.example.bookrental.Backend.model.entity.Book;
import com.example.bookrental.Backend.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    private final BookRepository bookRepository;
    //private final IAuthorService authorService;

    public BookService(BookRepository bookRepository) {//,IAuthorService authorService
        this.bookRepository = bookRepository;
        //this.authorService = authorService;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book saveBook(Book book) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public Book rentBook(Long id) {
        return null;
    }

    @Override
    public Book returnBook(Long id) {
        return null;
    }

    @Override
    public Book addBook(BookDto book) {
        return null;
    }
//    @Override
//    public Book getBookById(Long id) {
//        return bookRepository.findById(id).orElse(null);
//    }
    ////@Override
   // public Book addBook(BookDto book) {
    //    Book b = new Book();
     //   return saveBook(book, b);
    //}
    //private Book saveBook(BookDto book, Book b) {
    //    Author a = authorService.getAuthorById(book.getAuthor());

    //    if (a == null) {
     //       return null;
    //    }

     //   b.setName(book.getName());
     //   b.setCategory(book.getCategory());
    //    b.setAuthor(a);
     //   b.setAvailableCopies(book.getAvailableCopies());
//
     //   return bookRepository.save(b);
    //}
}
