package com.reto3.proyecto.service;


import com.reto3.proyecto.model.Message;
import com.reto3.proyecto.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessagesService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message>getAll(){return messageRepository.getAll();}
    public Optional<Message>getMessage(int id){
        return  messageRepository.getMessage(id);
    }
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if(e.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }

}
