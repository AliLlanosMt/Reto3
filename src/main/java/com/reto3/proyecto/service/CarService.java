package com.reto3.proyecto.service;

import com.reto3.proyecto.model.Car;
import com.reto3.proyecto.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.getAll();
    }
    public Optional <Car>getCar(int id ){ return carRepository.getCar(id);}


    public Car save(Car car){
        if(car.getId() == null){
            return carRepository.save(car);
        }
        else{
            Optional<Car> opt = carRepository.getCar(car.getId());
            if(opt.isEmpty()){
                return carRepository.save(car);
            }else{
                return car;
            }
        }
    }
    public Car update (Car car){
        if (car.getId()!=null){
            Optional<Car> q = carRepository.getCar(car.getId());
            if (q.isPresent()){
                if(car.getBrand()!=null){
                    q.get().setBrand(car.getBrand());
                }
                if(car.getModel()!=null){
                    q.get().setModel(car.getModel());
                }
                carRepository.save(q.get());
                return q.get();
            }else{
                return car;
            }
        }else{
            return car;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Car>car= carRepository.getCar(id);
        if(car.isPresent()){
            carRepository.delete(car.get());
            flag=true;
        }
        return flag;
    }
}
