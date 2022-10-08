package com.reto3.proyecto.repository;

import com.reto3.proyecto.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarCrudRepository extends CrudRepository<Car,Integer> {

    @Query("SELECT c.model,COUNT(c.model) FROM Car AS c group by c.model order by count(c.model) desc")
    public List<Object[]>countTotalCarByModel();
}
