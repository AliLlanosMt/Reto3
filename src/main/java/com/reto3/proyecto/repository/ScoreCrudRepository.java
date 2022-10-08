package com.reto3.proyecto.repository;

import com.reto3.proyecto.model.Category;
import com.reto3.proyecto.model.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score,Integer> {
}
