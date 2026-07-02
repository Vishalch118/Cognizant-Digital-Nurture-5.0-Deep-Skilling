package com.cognizant.spring_learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;

@RestController
public class CountryController {

    @GetMapping("/country")
    public Country getCountry() {
        CountryService countryService = new CountryService();
        return countryService.getCountry();
    }

    @GetMapping("/country/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        CountryService countryService = new CountryService();
        return countryService.getCountry(code);
    }
}