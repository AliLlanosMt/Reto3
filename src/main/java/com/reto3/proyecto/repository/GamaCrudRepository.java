package com.reto3.proyecto.repository;

import com.reto3.proyecto.model.Gama;
import com.reto3.proyecto.model.Score;
import org.springframework.data.repository.CrudRepository;

public interface GamaCrudRepository extends CrudRepository<Gama,Integer> {
}
