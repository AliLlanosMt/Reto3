package com.reto3.proyecto.repository;

import com.reto3.proyecto.model.Admin;
import com.reto3.proyecto.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){
        return(List<Admin>) adminCrudRepository.findAll();

    }

    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);

    }
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    public void  delete(Admin admin) {
        adminCrudRepository.delete(admin);}

}
