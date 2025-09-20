package com.moreiraf7.listmovies.repository;

import com.moreiraf7.listmovies.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface responsável pelo acesso ao banco de dados, e as implementações do JpaRepository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
