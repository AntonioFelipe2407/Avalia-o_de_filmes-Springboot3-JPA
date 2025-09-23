package com.moreiraf7.listmovies.resource;


import com.moreiraf7.listmovies.entities.User;
import com.moreiraf7.listmovies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/{id}") // Ao pesquisar a requisição retorna todos os usuarios
    public ResponseEntity<User> findById(@PathVariable Long id){ // Anotation para que o spring aceite o id como parametro ao realizar a request
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping // Endpoint para inserir elementos na request
    public ResponseEntity<User> insert(@RequestBody User user){ //Anotation para que o parametro seja passado no corpo da request
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}"). // pega a URI da requisicao atual e acrescenta um placeholder do novo id
                buildAndExpand(user.getId()).toUri(); // Substitui o placeHolder pelo novo id gerado
        return ResponseEntity.created(uri).body(user); // Retorna o status 201 created e no corpo o novo usuário inserido
    }

    @PutMapping(value = "/{id}") // Endpoint para inserir elementos na request
    public  ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        User user = service.update(id, obj);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}") // Endpoint para deletar elementos na request
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
