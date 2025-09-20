package com.moreiraf7.listmovies.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity //Anotation de que a classe é uma entidade
@Table(name = "tb_rating", //Anotation para dar o nome a tabela no banco de dados
        uniqueConstraints = { @UniqueConstraint(columnNames = {"user_id", "movie_id"}) // Validacao para que um usuario avalie o mesmo filme apenas 1 vez
})
public class Rating implements Serializable {

    @Id // Anotation diz que esse atributo é o id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotation para gerar o id automatico
    private Long id;

    //Anotation para validar a avaliação de 1 a 5
    @Min(1)
    @Max(5)
    private int rate;

    private Boolean watched;
    private String review;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dateRating;

    //ASSOCIACOES

    @ManyToOne
    @JoinColumn(name = "user_id") // Tranforma a associação em chave estrangeira
    @JsonIgnore //
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id") // Tranforma a associação em chave estrangeira
    private Movie movie;

    public Rating() {
    }

    public Rating(Long id, int rate, Boolean watched, String review, Instant dateRating, User user, Movie movie) {
        this.id = id;
        this.rate = rate;
        this.watched = watched;
        this.review = review;
        this.dateRating = dateRating;
        this.user = user;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Min(1)
    @Max(5)
    public int getRate() {
        return rate;
    }

    public void setRate(@Min(1) @Max(5) int rate) {
        this.rate = rate;
    }

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Instant getDateRating() {
        return dateRating;
    }

    public void setDateRating(Instant dateRating) {
        this.dateRating = dateRating;
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
        Rating rating = (Rating) o;
        return Objects.equals(id, rating.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
