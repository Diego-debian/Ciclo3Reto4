package com.diegoparra.ciclo3.reto3.service;

import com.diegoparra.ciclo3.reto3.model.Category;
import com.diegoparra.ciclo3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAll(){
        return (List<Category>) categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save(Category c){
        if (c.getId() == null){
            return categoryRepository.save(c);
        }
        else {
            Optional<Category> paux=categoryRepository.getCategory(c.getId());
            if (paux.isEmpty()){
                return categoryRepository.save(c);
            }
            else {
                return c;
            }
        }
    }

    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category> g= categoryRepository.getCategory(c.getId());
            if(!g.isEmpty()){
                if (c.getName()!=null){
                    g.get().setName(c.getName());
                }
                if (c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                return categoryRepository.save(g.get());
            }
        }
        return c;
    }
    public boolean deleteCategory(int id){
        Optional<Category> c = getCategory(id);
        if (!c.isEmpty()){
            categoryRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
