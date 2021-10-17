package com.diegoparra.ciclo3.reto3.service;

import com.diegoparra.ciclo3.reto3.model.Motorbike;
import com.diegoparra.ciclo3.reto3.model.Reservation;
import com.diegoparra.ciclo3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation r){
        if (r.getIdReservation()==null){
            return reservationRepository.save(r);
        }
        else {
            Optional<Reservation> paux=reservationRepository.getReservation(r.getIdReservation());
            if (paux.isEmpty()){
                return reservationRepository.save(r);
            }
            else {
                return r;
            }
        }
    }

    public Reservation update(Reservation c){
        if(c.getIdReservation()!=null){
            Optional<Reservation> g= reservationRepository.getReservation(c.getIdReservation());
            if(!g.isEmpty()){
                if (c.getStartDate()!=null){
                    g.get().setStartDate(c.getStartDate());
                }
                if (c.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(c.getDevolutionDate());
                }
                return reservationRepository.save(g.get());
            }
        }
        return c;
    }
    public boolean deleteReservation(int id){
        Optional<Reservation> c = getReservation(id);
        if (!c.isEmpty()){
            reservationRepository.delete(c.get());
            return true;
        }
        return false;
    }
}

