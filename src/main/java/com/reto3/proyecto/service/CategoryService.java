package com.reto3.proyecto.service;


import com.reto3.proyecto.model.Category;
import com.reto3.proyecto.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category>getAll(){return categoryRepository.getAll();}
    public Optional<Category>getCategory(int id){
        return  categoryRepository.getCategory(id);
    }
    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if(e.isPresent()){
                return category;
            }else{
                return categoryRepository.save(category);
            }
        }
    }

}
