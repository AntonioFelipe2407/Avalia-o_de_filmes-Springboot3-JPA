package com.moreiraf7.listmovies.repository;

import com.moreiraf7.listmovies.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface responsável pelo acesso ao banco de dados, e as implementações do JpaRepository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
