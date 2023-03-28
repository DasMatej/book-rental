package com.example.bookrental.Backend.service;

import com.example.bookrental.Backend.model.dto.CountryDto;
import com.example.bookrental.Backend.model.entity.Country;
import java.util.List;

public interface ICountryService {
    List<Country> getAllCountries();
    Country getCountryById(Long id);
    void deleteCountry(Long id);

    Country addCountry(CountryDto country);

    Country editCountry(Long id, CountryDto country);
}