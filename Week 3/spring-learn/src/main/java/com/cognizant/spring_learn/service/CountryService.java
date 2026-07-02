package com.cognizant.spring_learn.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring_learn.model.Country;

public class CountryService {

    public Country getCountry() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        return context.getBean("country", Country.class);
    }

    public Country getCountry(String code) {

        if ("IN".equalsIgnoreCase(code)) {
            Country country = new Country();
            country.setCode("IN");
            country.setName("India");
            return country;
        }

        return null;
    }
}