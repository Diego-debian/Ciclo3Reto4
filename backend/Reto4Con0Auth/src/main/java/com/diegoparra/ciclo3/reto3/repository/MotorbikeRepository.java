package com.diegoparra.ciclo3.reto3.repository;

import com.diegoparra.ciclo3.reto3.model.Category;
import com.diegoparra.ciclo3.reto3.model.Motorbike;
import com.diegoparra.ciclo3.reto3.repository.crud.MotorbikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MotorbikeRepository {
    @Autowired
    private MotorbikeCrudRepository motorbikeCrudRepository;
    public List<Motorbike> getAll(){
        return (List<Motorbike>) motorbikeCrudRepository.findAll();
    }
    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeCrudRepository.findById(id);
    }
    public Motorbike save(Motorbike m){
        return motorbikeCrudRepository.save(m);
    }
    public void delete(Motorbike c){
        motorbikeCrudRepository.delete(c);
    }
}
