package com.moreiraf7.listmovies.service;

import com.moreiraf7.listmovies.entities.Rating;
import com.moreiraf7.listmovies.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired // Injeção automatica
    private RatingRepository repository;

    //Metodo para retornar todos os usuarios
    public List<Rating> findAll(){
        return repository.findAll();
    }
}
