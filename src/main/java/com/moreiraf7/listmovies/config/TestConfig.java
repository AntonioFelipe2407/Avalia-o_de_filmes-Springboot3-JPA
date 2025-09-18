package com.moreiraf7.listmovies.config;

import com.moreiraf7.listmovies.entities.Movie;
import com.moreiraf7.listmovies.entities.User;
import com.moreiraf7.listmovies.repository.MovieRepository;
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

    @Autowired //Injeção automatica
    private MovieRepository movieRepository;



    @Override
    public void run(String... args) throws Exception {

        //Instanciando 2 obj e salvando no Banco de dados
        User u1 = new User(null, "Antonio", "antonio@gmail.com", "123");
        User u2 = new User(null, "Liliane", "liliane@gmail.com", "321");
        userRepository.saveAll(Arrays.asList(u1,u2));

        Movie m1 = new Movie(null, "Interstellar", "Ficcao Cientifica", 169, 2014, "Christopher Nolan");
        Movie m2 = new Movie(null, "La La Land", "Drama", 129, 2016, "Damien Chazelle");
        movieRepository.saveAll(Arrays.asList(m1, m2));


    }
}
