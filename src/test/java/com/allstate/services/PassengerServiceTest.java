package com.allstate.services;

import com.allstate.entities.Passenger;
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
@Sql(value = {"/sql/seed.sql"})
public class PassengerServiceTest {


    @Autowired
    private PassengerService passengerService;

    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreatePassenger() throws Exception {
        Passenger passenger = new Passenger(23,"Alice",Gender.FEMALE,10000);
        passenger = this.passengerService.create(passenger);
        assertEquals(4, passenger.getId());
        assertEquals("Alice", passenger.getName());
        assertEquals(Gender.FEMALE, passenger.getGender());
    }


    @Test
    public void shouldDeletePassenger() throws Exception {
        Passenger passenger = new Passenger(23,"Alice",Gender.FEMALE,10000);
        passenger = this.passengerService.create(passenger);
        this.passengerService.delete(passenger);
        Passenger d = this.passengerService.findById(4);
        assertNull(d);
    }

    @Test
    public void shouldfindAllPassengers() throws Exception {
        ArrayList<Passenger> passenger = this.passengerService.findAllPassengers();
        assertNotNull(passenger);
        assertEquals(3, passenger.size());
    }

}