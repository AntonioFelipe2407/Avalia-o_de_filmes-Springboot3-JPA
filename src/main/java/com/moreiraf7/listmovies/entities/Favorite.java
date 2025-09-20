package com.moreiraf7.listmovies.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity //Anotation de que a classe é uma entidade
@Table(name = "tb_favorite", //Anotation para dar o nome a tabela no banco de dados
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "movie_id"}) // Validacao para que um usuario nao favorite o mesmo filme 2 vezes
})
public class Favorite implements Serializable {

    @Id // Anotation diz que esse atributo é o id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotation para gerar o id automatico
    private Long id;

    //ASSOCIACOES
    
    @ManyToOne
    @JoinColumn(name = "user_id") // Tranforma a associação em chave estrangeira
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id") // Tranforma a associação em chave estrangeira
    private Movie movie;

    public Favorite() {
    }

    public Favorite(Long id, User user, Movie movie) {
        this.id = id;
        this.user = user;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorite favorite = (Favorite) o;
        return Objects.equals(id, favorite.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}


