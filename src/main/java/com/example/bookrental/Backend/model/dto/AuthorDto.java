package com.example.bookrental.Backend.model.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private String name;
    private String surname;
    private Long country;
}
