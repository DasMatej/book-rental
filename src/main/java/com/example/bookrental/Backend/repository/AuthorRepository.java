package com.example.bookrental.Backend.repository;

import com.example.bookrental.Backend.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
