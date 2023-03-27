package com.example.bookrental.Backend.controller;

import com.example.bookrental.Backend.model.enums.BookCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class BookCategoryController {
    @GetMapping("/allCategories")
    public List<BookCategory> getAllCategories() {
        return Arrays.asList(BookCategory.values());
    }
}
