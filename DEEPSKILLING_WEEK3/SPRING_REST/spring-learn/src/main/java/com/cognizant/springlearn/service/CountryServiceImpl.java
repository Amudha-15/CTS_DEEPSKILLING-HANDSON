package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public Country getCountry(String code) {
        List<Country> list = getCountryListFromXml();
        if (code == null) return null;
        String target = code.trim().toUpperCase();
        return list.stream()
                .filter(c -> c.getCode() != null && c.getCode().equalsIgnoreCase(target))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Country> getAllCountries() {
        return getCountryListFromXml();
    }

    @SuppressWarnings("unchecked")
    private List<Country> getCountryListFromXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> list = (List<Country>) context.getBean("countryList");
        ((ClassPathXmlApplicationContext) context).close();
        return list;
    }
}
