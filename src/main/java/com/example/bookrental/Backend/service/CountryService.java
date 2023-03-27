package com.example.bookrental.Backend.service;

import com.example.bookrental.Backend.model.entity.Country;
import com.example.bookrental.Backend.repository.CountryRepository;
import com.example.bookrental.Backend.service.ICountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return null;
    }

    @Override
    public Country getCountryById(Long id) {
        return null;
    }

    @Override
    public Country saveCountry(Country country) {
        return null;
    }

    @Override
    public void deleteCountry(Long id) {

    }
}
