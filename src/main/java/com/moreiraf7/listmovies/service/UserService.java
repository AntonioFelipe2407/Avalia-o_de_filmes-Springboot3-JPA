package com.moreiraf7.listmovies.service;

import com.moreiraf7.listmovies.entities.User;
import com.moreiraf7.listmovies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Anotation diz que a classe é um service
public class UserService {

    @Autowired // Injeção de dependencia automatica
    private UserRepository repository;

    //Metodo para retornar todos os usuarios
    public List<User> findAll() {
        return repository.findAll();
    }

    //Metodo para encontrar o usuario pelo id
    public User findById(Long id){
        Optional<User> user = repository.findById(id); // Optional pois o objeto pode existir ou nao no respositorio
        return user.orElseThrow(() -> new RuntimeException("Usuário não encontrado")); // Tratamento provisório
    }

    public User insert(User user){
        return repository.save(user);
    }


}
