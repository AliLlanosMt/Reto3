package com.reto3.proyecto.service;

import com.reto3.proyecto.model.Car;
import com.reto3.proyecto.model.Client;
import com.reto3.proyecto.repository.CarRepository;
import com.reto3.proyecto.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional <Client>getClient(int id ){ return clientRepository.getClient(id);}


    public Client save(Client client){
        if(client.getIdClient() == null){
            return clientRepository.save(client);
        }
        else{
            Optional<Client> opt = clientRepository.getClient(client.getIdClient());
            if(opt.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
    public Client update (Client client){
        if (client.getIdClient()!=null){
            Optional<Client> q = clientRepository.getClient(client.getIdClient());
            if (q.isPresent()){
                if(client.getName()!=null){
                    q.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    q.get().setAge(client.getAge());
                }
                if(client.getEmail()!=null){
                    q.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    q.get().setPassword(client.getPassword());
                }
                clientRepository.save(q.get());
                return q.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Client>client= clientRepository.getClient(id);
        if(client.isPresent()){
            clientRepository.delete(client.get());
            flag=true;
        }
        return flag;
    }
}
