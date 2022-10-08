package com.reto3.proyecto.controller;

import com.reto3.proyecto.model.Admin;
import com.reto3.proyecto.model.Car;
import com.reto3.proyecto.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @GetMapping("/all")
    public List<Admin>getCar(){
        return adminService.getAll();
    }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Admin save(@RequestBody Admin admin) {
        return adminService.save(admin);
   }
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int id){
        return adminService.getAdmin(id);
    }

}
