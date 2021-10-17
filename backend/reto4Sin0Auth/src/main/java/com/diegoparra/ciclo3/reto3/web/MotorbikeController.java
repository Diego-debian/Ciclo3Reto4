package com.diegoparra.ciclo3.reto3.web;

import com.diegoparra.ciclo3.reto3.model.Client;
import com.diegoparra.ciclo3.reto3.model.Motorbike;
import com.diegoparra.ciclo3.reto3.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Motorbike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MotorbikeController {
    @Autowired
    private MotorbikeService motorbikeService;

    @GetMapping("/all")
    public List<Motorbike> getMotorbikes(){
        return motorbikeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Motorbike> getMotorbike(@PathVariable("id") int id){
        return motorbikeService.getMotorbike(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody Motorbike m){
        return motorbikeService.save(m);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike update(@RequestBody Motorbike c){
        return motorbikeService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMotorbike(@PathVariable("id") int id){
        return motorbikeService.deleteMotorbike(id);
    }

}
