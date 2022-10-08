package com.reto3.proyecto.controller;

import com.reto3.proyecto.model.Car;

import com.reto3.proyecto.model.Category;
import com.reto3.proyecto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/all")
    public List<Category>getAll(){
        return categoryService.getAll();
    }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Category save(@RequestBody Category category) {

        return categoryService.save(category);
   }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }

}
