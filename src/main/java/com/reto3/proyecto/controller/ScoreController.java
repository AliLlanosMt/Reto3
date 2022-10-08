package com.reto3.proyecto.controller;

import com.reto3.proyecto.model.Car;
import com.reto3.proyecto.model.Score;
import com.reto3.proyecto.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @GetMapping("/all")
    public List<Score>getAll(){
        return scoreService.getAll();
    }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Score save(@RequestBody Score score ) {
        return scoreService.save(score);
   }
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int id){
        return scoreService.getScore(id);
    }

}
