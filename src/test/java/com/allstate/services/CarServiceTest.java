package com.allstate.services;


import com.allstate.entities.Car;
import com.allstate.enums.CarType;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = "/sql/seed.sql")
public class CarServiceTest {
    @Autowired
    private CarService carService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCar() throws Exception {
       Car car = new Car("Fe","ds",2012,CarType.BASIC);
        this.carService.create(car);
        assertEquals(5,car.getId());
    }

    @Test
    public  void shouldDeleteCar() throws Exception{
        Car car = new Car("Fe","ds",2012,CarType.BASIC);
        this.carService.create(car);
        this.carService.delete(car);
        Car c = this.carService.findById(5);
        assertNull(c);
    }

    @Test
    public void shouldFindAllCars() throws Exception{
        ArrayList<Car> car = this.carService.findAllCars();
        assertNotNull(car);
        assertEquals(4, car.size());
    }



}