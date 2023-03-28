package com.example.bookrental.Backend.service;

import com.example.bookrental.Backend.model.dto.BookDto;
import com.example.bookrental.Backend.model.entity.Author;
import com.example.bookrental.Backend.model.entity.Book;
import com.example.bookrental.Backend.model.entity.Country;
import com.example.bookrental.Backend.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final IAuthorService authorService;

    public BookService(BookRepository bookRepository,IAuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
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
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book editBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return null;
        }

        return saveBook(bookDto, book);
    }

    @Override
    public void markBookAsTaken(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return;
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
    }

    @Override
    public Book addBook(BookDto book) {
        Book b = new Book();
        return saveBook(book, b);
    }

    @Override
    public List<Book> getBooksByAuthorId(Long id) {
        return bookRepository.findByAuthorId(id);
    }

    @Override
    public List<Book> getBooksByCountry(Country country) {
        return bookRepository.findByCountry(country);
    }

    private Book saveBook(BookDto bookDto, Book book) {
        Author author = authorService.getAuthorById(bookDto.getAuthor());

        if (author == null) {
            return null;
        }
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return bookRepository.save(book);
    }
}
