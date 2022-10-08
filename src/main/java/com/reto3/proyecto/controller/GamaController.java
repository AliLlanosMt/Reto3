package com.reto3.proyecto.controller;

import com.reto3.proyecto.model.Car;
import com.reto3.proyecto.model.Gama;
import com.reto3.proyecto.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Gama")
public class GamaController {

    @Autowired
    private GamaService gamaService;
    @GetMapping("/all")
    public List<Gama>getGama(){
        return gamaService.getAll();
    }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Gama save(@RequestBody Gama gama) {
        return gamaService.save(gama);
   }

}
