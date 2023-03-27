package com.example.bookrental.Backend.controller;

import com.example.bookrental.Backend.model.entity.Country;
import com.example.bookrental.Backend.service.ICountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private ICountryService countryService;

    @GetMapping("")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

}