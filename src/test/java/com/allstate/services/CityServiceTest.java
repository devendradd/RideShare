package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.enums.Gender;
import com.allstate.repositories.ICityRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Autowired
    private DriverService driverService;

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCity() throws Exception {
        City city = new City("Bhopal", "MP", 50, 75);
        city = this.cityService.create(city);
        assertEquals(6, city.getId());
        assertEquals("Bhopal", city.getName());
    }


    @Test
    public void shouldDeleteCity() throws Exception {
        City city = new City("Bhopal", "MP", 50, 75);
        city = this.cityService.create(city);
        this.cityService.delete(city);
        City d = this.cityService.findById(6);
        assertNull(d);
    }

    @Test
    public void shouldFindAllCities() throws Exception {
        ArrayList<City> city = this.cityService.findAllCities();
        assertNotNull(city);
        assertEquals(5, city.size());

    }

    @Test
    @Transactional
    public  void shouldFindAllDriversInCity() throws Exception {
        assertEquals(2, this.cityService.findAllDriversInCityById(1));
    }



}