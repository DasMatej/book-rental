package com.example.bookrental.Backend.controller;

import com.example.bookrental.Backend.ResourceNotFoundException;
import com.example.bookrental.Backend.model.entity.Country;
import com.example.bookrental.Backend.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private ICountryService countryService;

    @GetMapping("")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    //@GetMapping("/{id}")
    //public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") Long countryId)
    //        throws ResourceNotFoundException {
    //    Country country = countryService.getCountryById(countryId)
    //            .orElseThrow(() -> new ResourceNotFoundException("Country not found for this id :: " + countryId));
    //    return ResponseEntity.ok().body(country);
    //}

    //@PostMapping("")
    //public Country createCountry(@RequestBody Country country) {
    //    return countryService.createCountry(country);
    //}

    //@PutMapping("/{id}")
    //public ResponseEntity<Country> updateCountry(@PathVariable(value = "id") Long countryId,
    //                                             @RequestBody Country countryDetails) throws ResourceNotFoundException {
    ///    Country updatedCountry = countryService.updateCocan yuntry(countryId, countryDetails);
    //    return ResponseEntity.ok(updatedCountry);
    //}

//    @DeleteMapping("/{id}")
//    public Map<String, Boolean> deleteCountry(@PathVariable(value = "id") Long countryId)
//            throws ResourceNotFoundException {
//        countryService.deleteCountry(countryId);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
}