package com.moreiraf7.listmovies.resource;


import com.moreiraf7.listmovies.entities.User;
import com.moreiraf7.listmovies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping // Endpoint para inserir elementos na request
    public ResponseEntity<User> insert(@RequestBody User user){ //Anotation para que o parametro seja passado no corpo da request
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}"). // pega a URI da requisicao atual e acrescenta um placeholder do novo id
                buildAndExpand(user.getId()).toUri(); // Substitui o placeHolder pelo novo id gerado
        return ResponseEntity.created(uri).body(user); // Retorna o status 201 created e no corpo o novo usuário inserido
    }
}
