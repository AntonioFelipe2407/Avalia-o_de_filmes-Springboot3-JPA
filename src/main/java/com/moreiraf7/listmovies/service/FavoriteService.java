package com.moreiraf7.listmovies.service;

import com.moreiraf7.listmovies.entities.Favorite;
import com.moreiraf7.listmovies.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired // Injeção automatica
    private FavoriteRepository repository;

    //Metodo para retornar todos os usuarios
    public List<Favorite> findAll(){
        return repository.findAll();
    }
}
