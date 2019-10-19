package br.com.escolainformatica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Professor implements Serializable {
    private static final long serialVersionUID = 423811117059584660L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;

    public Professor(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Professor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
