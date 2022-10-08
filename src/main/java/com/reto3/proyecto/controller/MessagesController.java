package com.reto3.proyecto.controller;

import com.reto3.proyecto.model.Message;
import com.reto3.proyecto.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Messages")
public class MessagesController {

    @Autowired
    private MessagesService messagesService;
    @GetMapping("/all")
    public List<Message>getAll(){
        return messagesService.getAll();
    }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Message save(@RequestBody Message message) {
        return messagesService.save(message);
   }

}
