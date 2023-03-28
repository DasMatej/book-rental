package com.example.bookrental.Backend.controller;

import com.example.bookrental.Backend.model.dto.AuthorDto;
import com.example.bookrental.Backend.model.entity.Author;
import com.example.bookrental.Backend.model.entity.Book;
import com.example.bookrental.Backend.service.IAuthorService;
import com.example.bookrental.Backend.service.IBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final IAuthorService authorService;
    private final IBookService bookService;


    public AuthorController(IAuthorService authorService, IBookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/allAuthors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody AuthorDto author) {
        Author newAuthor = authorService.addAuthor(author);

        if (newAuthor == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newAuthor);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {
        Author author = authorService.getAuthorById(id);

        if (author == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Book> books = bookService.getBooksByAuthorId(id);
            for (Book book : books) {
                bookService.deleteBook(book.getId());
            }
            authorService.deleteAuthor(id);
            return ResponseEntity.ok(author);
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> editAuthor(@PathVariable Long id, @RequestBody AuthorDto author) {
        Author newAuthor = authorService.editAuthor(id, author);
        if (newAuthor == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newAuthor);
        }
    }
}