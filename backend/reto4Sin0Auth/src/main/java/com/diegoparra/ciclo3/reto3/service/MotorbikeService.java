package com.diegoparra.ciclo3.reto3.service;

import com.diegoparra.ciclo3.reto3.model.Message;
import com.diegoparra.ciclo3.reto3.model.Motorbike;
import com.diegoparra.ciclo3.reto3.repository.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorbikeService {
    @Autowired
    private MotorbikeRepository motorbikeRepository;
    public List<Motorbike> getAll(){
        return motorbikeRepository.getAll();
    }
    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeRepository.getMotorbike(id);
    }
    public Motorbike save(Motorbike m){
        if(m.getId() == null){
            return motorbikeRepository.save(m);
        }
        else {
            Optional<Motorbike> paux=motorbikeRepository.getMotorbike(m.getId());
            if (paux.isEmpty()){
                return motorbikeRepository.save(m);
            }else {
                return m;
            }
        }

    }

    public Motorbike update(Motorbike c){
        if(c.getId()!=null){
            Optional<Motorbike> g= motorbikeRepository.getMotorbike(c.getId());
            if(!g.isEmpty()){
                if (c.getName()!=null){
                    g.get().setName(c.getName());
                }
                if (c.getName()!=null){
                    g.get().setName(c.getName());
                }
                if (c.getBrand()!=null){
                    g.get().setBrand(c.getBrand());
                }
                if (c.getYear()!=null){
                    g.get().setYear(c.getYear());
                }
                if (c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                return motorbikeRepository.save(g.get());
            }
        }
        return c;
    }
    public boolean deleteMotorbike(int id){
        Optional<Motorbike> c = getMotorbike(id);
        if (!c.isEmpty()){
            motorbikeRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
