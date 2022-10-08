package com.reto3.proyecto.repository;

import com.reto3.proyecto.model.Admin;
import com.reto3.proyecto.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminCrudRepository extends CrudRepository<Admin,Integer> {


}
