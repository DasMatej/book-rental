package com.example.bookrental.Backend.repository;

import com.example.bookrental.Backend.model.entity.Author;
import com.example.bookrental.Backend.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByCountry(Country country);
}
