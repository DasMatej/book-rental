package com.example.bookrental.Backend.repository;

import com.example.bookrental.Backend.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
