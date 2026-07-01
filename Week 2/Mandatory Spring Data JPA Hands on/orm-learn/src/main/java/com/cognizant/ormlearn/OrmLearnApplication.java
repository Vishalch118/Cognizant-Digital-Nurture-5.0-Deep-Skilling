package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication 
{
    private static EmployeeService employeeService;
    private static final Logger LOGGER=LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    public static void main(String args[]) 
	{
        ApplicationContext context=SpringApplication.run(OrmLearnApplication.class,args);
        countryService=context.getBean(CountryService.class);
        employeeService=context.getBean(EmployeeService.class);

        // testGetAllCountries();
        // testFindCountry();
        // testAddCountry();
        // testSearchCountries();
        //testSearchCountriesSorted();
        //testCountriesStartingWith();
        //testGetEmployee();
        //testGetPermanentEmployees();
        testNativeQuery();
    }

    private static void testGetAllCountries() 
	{
        LOGGER.info("Start");
        List<Country> countries=countryService.getAllCountries();

        LOGGER.debug("Countries={}",countries);
        LOGGER.info("End");
    }

    private static void testFindCountry() 
    {
        LOGGER.info("Start");
        Country country=countryService.findCountryByCode("IN");

        LOGGER.debug("Country={}",country);
        LOGGER.info("End");
    }

    private static void testAddCountry() 
    {
        LOGGER.info("Start");
        Country country=new Country();

        country.setCode("JP");
        country.setName("Japan");
        countryService.addCountry(country);

        LOGGER.info("End");
    }

    private static void testSearchCountries() 
    {
        LOGGER.info("Start");

        List<Country> countries=countryService.searchCountries("ou");

        LOGGER.debug("Countries={}",countries);
        LOGGER.info("End");
    }

    private static void testSearchCountriesSorted() 
    {
        LOGGER.info("Start");

        List<Country> countries=countryService.searchCountriesSorted("ou");

        LOGGER.debug("Countries={}",countries);
        LOGGER.info("End");
    }

    private static void testCountriesStartingWith() 
    {
        LOGGER.info("Start");

        List<Country> countries=countryService.getCountriesStartingWith("Z");

        LOGGER.debug("Countries={}",countries);
        LOGGER.info("End");
    }

    private static void testGetEmployee() 
    {
        LOGGER.info("Start");

        Employee employee=employeeService.get(1);

        LOGGER.debug("Employee={}",employee);
        LOGGER.debug("Department={}",employee.getDepartment());
        LOGGER.debug("Skills={}",employee.getSkillList());

        LOGGER.info("End");
    }

    private static void testGetPermanentEmployees() 
    {
        LOGGER.info("Start");

        List<Employee> employees=employeeService.getAllPermanentEmployees();

        LOGGER.debug("Employees={}",employees);

        employees.forEach(
                e->LOGGER.debug(
                        "Skills={}",
                        e.getSkillList()
                )
        );

        LOGGER.info("End");
    }

    private static void testNativeQuery() 
    {
        LOGGER.info("Start");

        List<Employee> employees=employeeService.getAllPermanentEmployeesNative();

        LOGGER.debug("Employees={}",employees);
        LOGGER.info("End");
    }
}