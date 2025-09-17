package com.moreiraf7.listmovies.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity //Anotation de que a classe é uma entidade
@Table(name = "tb_user") //Anotation para dar o nome a tabela no banco de dados
public class User implements Serializable {

    @Id // Anotation diz que esse atributo é o id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotation para gerar o id automatico
    private Long id;

    private String nome;
    private String email;
    private String senha;

    public User() {
    }

    public User(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
