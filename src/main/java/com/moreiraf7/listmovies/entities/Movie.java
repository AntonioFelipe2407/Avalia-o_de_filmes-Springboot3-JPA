package com.moreiraf7.listmovies.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity //Anotation de que a classe é uma entidade
@Table(name = "tb_movie") //Anotation para dar o nome a tabela no banco de dados
public class Movie implements Serializable {

    @Id // Anotation diz que esse atributo é o id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotation para gerar o id automatico
    private Long id;
    private String title;
    private String gender;
    private Integer durationMinutes;
    private Integer year;
    private String directedBy;

    public Movie() {
    }

    public Movie(Long id, String title, String gender, Integer durationMinutes, Integer year, String directedBy) {
        this.id = id;
        this.title = title;
        this.gender = gender;
        this.durationMinutes = durationMinutes;
        this.year = year;
        this.directedBy = directedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDirectedBy() {
        return directedBy;
    }

    public void setDirectedBy(String directedBy) {
        this.directedBy = directedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
