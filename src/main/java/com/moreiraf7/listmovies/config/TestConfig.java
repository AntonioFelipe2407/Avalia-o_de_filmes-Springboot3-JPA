package com.moreiraf7.listmovies.config;

import com.moreiraf7.listmovies.entities.Favorite;
import com.moreiraf7.listmovies.entities.Movie;
import com.moreiraf7.listmovies.entities.Rating;
import com.moreiraf7.listmovies.entities.User;
import com.moreiraf7.listmovies.repository.FavoriteRepository;
import com.moreiraf7.listmovies.repository.MovieRepository;
import com.moreiraf7.listmovies.repository.RatingRepository;
import com.moreiraf7.listmovies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired //Injeção automatica
    private UserRepository userRepository;

    @Autowired //Injeção automatica
    private MovieRepository movieRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Override
    public void run(String... args) throws Exception {

        //Instanciando 2 obj e salvando no Banco de dados
        User u1 = new User(null, "Antonio", "antonio@gmail.com", "123");
        User u2 = new User(null, "Liliane", "liliane@gmail.com", "321");
        userRepository.saveAll(Arrays.asList(u1,u2));

        //Instanciando 2 obj e salvando no Banco de dados
        Movie m1 = new Movie(null, "Interstellar", "Ficcao Cientifica", 169, 2014, "Christopher Nolan");
        Movie m2 = new Movie(null, "La La Land", "Drama", 129, 2016, "Damien Chazelle");
        movieRepository.saveAll(Arrays.asList(m1, m2));

        //Instanciando 2 obj e salvando no Banco de dados
        Rating r1 = new Rating(null, 5, true," ", Instant.parse("2025-09-16T19:53:07Z"), u1, m1);
        Rating r2 = new Rating(null, 3, true," ", Instant.parse("2025-09-17T19:53:07Z"), u2, m1);
        Rating r3 = new Rating(null, 5, true," ", Instant.parse("2025-09-18T19:53:07Z"), u2, m2);
        Rating r4 = new Rating(null, 2, true," ", Instant.parse("2025-09-18T20:53:07Z"), u1, m2);

        ratingRepository.saveAll(Arrays.asList(r1, r2, r3, r4));

        Favorite f1 = new Favorite(null, u1, m1);
        Favorite f2 = new Favorite(null, u2, m2);

        favoriteRepository.saveAll(Arrays.asList(f1, f2));

    }
}
