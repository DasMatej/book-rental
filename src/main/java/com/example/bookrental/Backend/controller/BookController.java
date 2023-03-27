package com.example.bookrental.Backend.controller;

import com.example.bookrental.Backend.model.dto.BookDto;
import com.example.bookrental.Backend.model.entity.Book;
import com.example.bookrental.Backend.service.IBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody BookDto book) {
        Book newBook = bookService.addBook(book);

        if (newBook == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newBook);
        }
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.deleteBook(id);
            return ResponseEntity.ok(book);
        }
    }

    @PutMapping("/editBook/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto book) {
        Book newBook = bookService.editBook(id, book);

        if (newBook == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newBook);
        }
    }

    @PutMapping("/markBook/{id}")
    public ResponseEntity<Book> markBookAsTaken(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.markBookAsTaken(id);
            return ResponseEntity.ok(book);
        }
    }
}