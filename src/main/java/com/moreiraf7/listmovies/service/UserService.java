package com.moreiraf7.listmovies.service;

import com.moreiraf7.listmovies.entities.User;
import com.moreiraf7.listmovies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Anotation diz que a classe é um service
public class UserService {

    @Autowired // Injeção de dependencia automatica
    private UserRepository repository;

    //Metodo para retornar todos os usuarios
    public List<User> findAll() {
        return repository.findAll();
    }
}
