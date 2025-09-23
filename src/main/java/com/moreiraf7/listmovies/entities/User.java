package com.moreiraf7.listmovies.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity //Anotation de que a classe é uma entidade
@Table(name = "tb_user") //Anotation para dar o name a tabela no banco de dados
public class User implements Serializable {

    @Id // Anotation diz que esse atributo é o id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotation para gerar o id automatico
    private Long id;

    private String name;
    private String email;
    private String password;

    //ASSOCIACOES

    @OneToMany(mappedBy = "user",  // Transformando a associação em FK
            cascade = CascadeType.ALL, //Ao mexer no usuario, mexe nas avaliacoes tambem
            orphanRemoval = true)  // Ao deletar o usuario, suas avaliacoes tambem serao deletadas no banco
    private Set<Rating> ratings = new HashSet<>();

    @OneToMany(mappedBy = "user", // Transformando a associação em FK
            cascade = CascadeType.ALL, //Ao mexer no usuario, mexe nas avaliacoes tambem
            orphanRemoval = true)  // Ao deletar o usuario, suas avaliacoes tambem serao deletadas no banco
    private Set<Favorite> favorites = new HashSet<>();

    public User() {
    }

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // getter da associação
    public Set<Rating> getRatings() {
        return ratings;
    }

    // getter da associação
    public Set<Favorite> getFavorites() {
        return favorites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User usuario = (User) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
