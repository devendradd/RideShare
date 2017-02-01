package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class DriverServiceTest {
    @Autowired
    private DriverService driverService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldcreateNewDriver() throws Exception {
        Driver driver = new Driver("alice", 22, Gender.FEMALE, 0);
        driver = this.driverService.create(driver);
        assertEquals(5, driver.getId());
        assertEquals("alice", driver.getName());
        assertEquals(Gender.FEMALE, driver.getGender());
    }

    @Test
    public void shouldDeleteDriver() throws Exception {
        Driver driver = new Driver("alice", 22, Gender.FEMALE, 0);
        driver = this.driverService.create(driver);
        this.driverService.delete(driver);
        Driver d = this.driverService.findById(5);
        assertNull(d);

    }

    @Test
    public void shouldFindAllDrivers() throws Exception{
        ArrayList<Driver> driver = this.driverService.findAllDrivers();
        assertNotNull(driver);
        assertEquals(4, driver.size());
    }

    @Test
    public  void shouldUpdateTheVoilationTicket() throws Exception{
        Driver driver = new Driver("alice", 22, Gender.FEMALE, 0);
        driver = this.driverService.create(driver);
        this.driverService.addVoilation(driver);
        assertEquals(1,driver.getTickets());
    }

    @Test
    public void findDriverBannedOrNot() throws  Exception{
        Driver driver = new Driver("alice", 22, Gender.FEMALE, 0);
        driver = this.driverService.create(driver);
        assertEquals(false,this.driverService.isDriverBanned(driver));
    }

    @Test
    @Transactional
    public void shouldFindCitiesByDriver() throws Exception {
        Driver driver = new Driver("alice", 22, Gender.FEMALE, 0);
        assertEquals(2,this.driverService.findAllCities(driver));

    }

}