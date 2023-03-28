package com.example.bookrental.Backend.repository;

import com.example.bookrental.Backend.model.entity.Book;
import com.example.bookrental.Backend.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Long id);
    List<Book> findByCountry(Country country);
}
