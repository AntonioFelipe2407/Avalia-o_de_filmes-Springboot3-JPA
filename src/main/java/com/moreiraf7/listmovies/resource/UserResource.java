package com.moreiraf7.listmovies.resource;


import com.moreiraf7.listmovies.entities.User;
import com.moreiraf7.listmovies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Anotation diz que a classe é um controller (resource)
@RequestMapping(value = "/users") // Anotation com o value para mapear a riquisicao
public class UserResource {

    @Autowired // Injeção de dependência automatica
    private UserService service;

    @GetMapping // Ao pesquisar a requisição retorna todos os usuarios
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
