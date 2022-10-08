package com.reto3.proyecto.repository;



import com.reto3.proyecto.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientCrudRepository extends CrudRepository<Client,Integer> {


}
