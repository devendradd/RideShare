package com.allstate.services;


import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.repositories.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {
    private IDriverRepository driverRepository;

    @Autowired
    public void setDriverRepository(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver create(Driver driver){
       return  this.driverRepository.save(driver);
    }

    public Driver findById(int id) {
        return this.driverRepository.findOne(id);
    }

    public ArrayList<Driver> findAllDrivers(){
        ArrayList<Driver> driver = (ArrayList<Driver>)  this.driverRepository.findAll();
        return driver;
    }
    public  void addVoilation(Driver driver){
        int tickets = driver.getTickets();
        driver.setTickets(tickets +1);
    }

    public  boolean isDriverBanned(Driver driver){
        return (driver.getTickets() >= 3) ? true : false;
    }

    public void delete(Driver driver){  this.driverRepository.delete(driver);}

    public ArrayList<City> findAllCities(Driver driver){
        return this.driverRepository.findAllCitiesForDriverByDriverId(driver.getId());
    }
}
