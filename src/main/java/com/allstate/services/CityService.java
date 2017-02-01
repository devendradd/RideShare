package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private ICityRepository cityRepository;

    public void setCityRepository(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City create(City city){
        return this.cityRepository.save(city);
    }

    public City findById(int id) {
        return this.cityRepository.findOne(id);
    }

    public void delete(City city){
        this.cityRepository.delete(city);
    }

    public ArrayList<City> findAllCities(){
        ArrayList<City> city = (ArrayList<City>)  this.cityRepository.findAll();
        return city;
    }
    public List<Driver> findAllDriversInCityById(int id){
        return this.cityRepository.findAllDriversInCityById(id);
    }
}
