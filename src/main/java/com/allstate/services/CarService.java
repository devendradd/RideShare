package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.repositories.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService {
    @Autowired
    private ICarRepository carRepository;

    public void setCarRepository(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public Car create(Car car){
        return this.carRepository.save(car);
    }

    public Car findById(int id) {
        return this.carRepository.findOne(id);
    }

    public void delete(Car car){
        this.carRepository.delete(car);
    }

    public ArrayList<Car> findAllCars(){
        ArrayList<Car> car = (ArrayList<Car>)  this.carRepository.findAll();
        return car;
    }

}
