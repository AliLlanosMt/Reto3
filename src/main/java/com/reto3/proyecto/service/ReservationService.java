package com.reto3.proyecto.service;

import com.reto3.proyecto.model.Client;
import com.reto3.proyecto.model.Reservation;
import com.reto3.proyecto.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional <Reservation>getReservation(int id ){ return reservationRepository.getReservation(id);}


    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        }
        else{
            Optional<Reservation> opt = reservationRepository.getReservation(reservation.getIdReservation());
            if(opt.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    public Reservation update (Reservation reservation){
        if (reservation.getIdReservation()!=null){
            Optional<Reservation> q = reservationRepository.getReservation(reservation.getIdReservation());
            if (q.isPresent()){
                if(reservation.getStartDate()!=null){
                    q.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getEndDate()!=null){
                    q.get().setEndDate(reservation.getEndDate());
                }
                if(reservation.getStatus()!=null){
                    q.get().setStatus(reservation.getStatus());
                }

                reservationRepository.save(q.get());
                return q.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>reservation= reservationRepository.getReservation(id);
        if(reservation.isPresent()){
            reservationRepository.delete(reservation.get());
            flag=true;
        }
        return flag;
    }
}
