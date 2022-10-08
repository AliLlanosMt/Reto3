package com.reto3.proyecto.repository;

import com.reto3.proyecto.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
