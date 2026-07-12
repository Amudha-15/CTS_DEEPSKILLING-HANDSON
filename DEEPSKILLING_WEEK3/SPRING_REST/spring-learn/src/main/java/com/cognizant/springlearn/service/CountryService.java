package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;

import java.util.List;

public interface CountryService {
    Country getCountry(String code);
    List<Country> getAllCountries();
}
