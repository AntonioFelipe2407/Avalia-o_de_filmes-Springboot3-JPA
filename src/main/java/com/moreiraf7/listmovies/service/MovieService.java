package com.moreiraf7.listmovies.service;

import com.moreiraf7.listmovies.entities.Movie;
import com.moreiraf7.listmovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired // Injeção de dependência automatica
    private MovieRepository repository;

    //Operação para retornar todos os filmes
    public List<Movie> findAll(){
        return repository.findAll();
    }


}
