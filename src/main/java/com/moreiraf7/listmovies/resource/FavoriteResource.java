package com.moreiraf7.listmovies.resource;

import com.moreiraf7.listmovies.entities.Favorite;
import com.moreiraf7.listmovies.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Anotation diz que a classe é um controller (resource)
@RequestMapping(value = "/favorites") // Anotation com o value para mapear a riquisicao
public class FavoriteResource {

    @Autowired // Injeção de dependência automatica
    private FavoriteService service;

    @GetMapping // Ao pesquisar a requisição retorna todos os filmes
    public ResponseEntity<List<Favorite>> findAll(){
        List<Favorite> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
