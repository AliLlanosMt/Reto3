package com.reto3.proyecto.controller;

import com.reto3.proyecto.model.Client;
import com.reto3.proyecto.model.Reservation;
import com.reto3.proyecto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @GetMapping("/all")
    public List<Reservation>getReservation(){
        return reservationService.getAll();
    }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
   }

}
