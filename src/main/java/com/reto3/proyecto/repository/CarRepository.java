package com.reto3.proyecto.repository;

import com.reto3.proyecto.model.Car;
import com.reto3.proyecto.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    @Autowired
    private CarCrudRepository carCrudRepository;

    public List<Car> getAll(){
        return(List<Car>) carCrudRepository.findAll();

    }

    public Car save(Car car){
        return carCrudRepository.save(car);

    }
    public Optional<Car> getCar(int id){

        return carCrudRepository.findById(id);
    }
    public void  delete(Car car) {carCrudRepository.delete(car);}

}
