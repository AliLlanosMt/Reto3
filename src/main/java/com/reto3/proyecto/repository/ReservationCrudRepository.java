package com.reto3.proyecto.repository;



import com.reto3.proyecto.model.Client;
import com.reto3.proyecto.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {


}
