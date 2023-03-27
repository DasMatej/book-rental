package com.example.bookrental.Backend.model.dto;

import com.example.bookrental.Backend.model.enums.BookCategory;
import lombok.Data;

@Data
public class BookDto {
    private String name;
    private Long author;
    private BookCategory category;
    private Integer copies;
}
