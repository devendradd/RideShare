package com.allstate.services;

import com.allstate.entities.Passenger;
import com.allstate.repositories.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PassengerService {
    @Autowired
    private IPassengerRepository passengerRepository;

    public void setPassengerRepository(IPassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }


    public Passenger create(Passenger passenger){
        return this.passengerRepository.save(passenger);
    }

    public Passenger findById(int id) {
        return this.passengerRepository.findOne(id);
    }

    public void delete(Passenger passenger){
        this.passengerRepository.delete(passenger);
    }

    public ArrayList<Passenger> findAllPassengers(){
        ArrayList<Passenger> passenger = (ArrayList<Passenger>)  this.passengerRepository.findAll();
        return passenger;
    }
}
