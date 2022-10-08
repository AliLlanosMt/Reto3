package com.reto3.proyecto.controller;

import com.reto3.proyecto.model.Car;
import com.reto3.proyecto.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Car")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})
public class CarController {

    @Autowired
    private CarService carService;
    @GetMapping("/all")
    public List<Car>getCar(){
        return carService.getAll();
    }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Car save(@RequestBody Car car) {
        return carService.save(car);
   }

   @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable("id") int id){
        return carService.getCar(id);
   }

}
