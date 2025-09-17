package com.moreiraf7.listmovies.config;

import com.moreiraf7.listmovies.entities.User;
import com.moreiraf7.listmovies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired //Injeção automatica
    private UserRepository userRepository;



    @Override
    public void run(String... args) throws Exception {

        //Instanciando 2 obj e salvando no Banco de dados
        User u1 = new User(null, "Antonio", "antonio@gmail.com", "123");
        User u2 = new User(null, "Liliane", "liliane@gmail.com", "321");
        userRepository.saveAll(Arrays.asList(u1,u2));

    }
}
