package com.example.bookrental.Backend.service;

import com.example.bookrental.Backend.model.entity.Country;
import java.util.List;

public interface ICountryService {
    List<Country> getAllCountries();
    Country getCountryById(Long id);
    Country saveCountry(Country country);
    void deleteCountry(Long id);
}