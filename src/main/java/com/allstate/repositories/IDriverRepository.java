package com.allstate.repositories;


import com.allstate.entities.City;
import com.allstate.entities.Driver;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface IDriverRepository extends CrudRepository<Driver, Integer>{
    @Query(value = "select d,c from Driver d, City c  where d.city_id = c.id", nativeQuery = true)
    public ArrayList<City> findAllCitiesForDriverByDriverId(@Param("id") int id);
}
