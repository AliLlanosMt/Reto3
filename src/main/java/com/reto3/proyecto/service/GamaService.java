package com.reto3.proyecto.service;

import com.reto3.proyecto.model.Car;
import com.reto3.proyecto.model.Gama;
import com.reto3.proyecto.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {
    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll(){
        return gamaRepository.getAll();
    }
    public Optional <Gama>getGama(int id ){ return gamaRepository.getGama(id);}


    public Gama save(Gama gama){
        if(gama.getIdGama() == null){
            return gamaRepository.save(gama);
        }
        else{
            Optional<Gama> opt = gamaRepository.getGama(gama.getIdGama());
            if(opt.isEmpty()){
                return gamaRepository.save(gama);
            }else{
                return gama;
            }
        }
    }
    public Gama update (Gama gama){
        if (gama.getIdGama()!=null){
            Optional<Gama> q = gamaRepository.getGama(gama.getIdGama());
            if (q.isPresent()){
                if(gama.getName()!=null){
                    q.get().setName(gama.getName());
                }
                if(gama.getDescription()!=null){
                    q.get().setDescription(gama.getDescription());
                }
                gamaRepository.save(q.get());
                return q.get();
            }else{
                return gama;
            }
        }else{
            return gama;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Gama>gama= gamaRepository.getGama(id);
        if(gama.isPresent()){
            gamaRepository.delete(gama.get());
            flag=true;
        }
        return flag;
    }
}
