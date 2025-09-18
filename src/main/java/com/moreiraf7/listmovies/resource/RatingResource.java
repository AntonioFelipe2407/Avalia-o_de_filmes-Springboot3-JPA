package com.moreiraf7.listmovies.resource;


import com.moreiraf7.listmovies.entities.Rating;
import com.moreiraf7.listmovies.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Anotation diz que a classe é um controller (resource)
@RequestMapping(value = "/ratings") // Anotation com o value para mapear a riquisicao
public class RatingResource {

    @Autowired // Injeção automatica
    private RatingService service;

    // Ao pesquisar a requisição retorna todos os usuarios
    @GetMapping
    public ResponseEntity<List<Rating>> findAll(){
        List<Rating> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
