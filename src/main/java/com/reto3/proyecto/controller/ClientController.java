package com.reto3.proyecto.controller;

import com.reto3.proyecto.model.Car;
import com.reto3.proyecto.model.Client;
import com.reto3.proyecto.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/all")
    public List<Client>getClient(){
        return clientService.getAll();
    }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Client save(@RequestBody Client client) {
        return clientService.save(client);
   }
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id){
        return clientService.getClient(id);
    }

}
