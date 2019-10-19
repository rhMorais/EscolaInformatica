package br.com.escolainformatica.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
@Table
public class Aluno implements Serializable {
    private static final long serialVersionUID = -983084391168890999L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_nascimento;

    @Column(nullable = false)
    private double cpf;

    @ManyToMany(mappedBy = "alunos")
    @JsonIgnore
    private List<Turma> turmas;

    public Aluno(Integer id, String nome, Date data_nascimento, double cpf) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
    }

    public Aluno() {
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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public double getCpf() {
        return cpf;
    }

    public void setCpf(double cpf) {
        this.cpf = cpf;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
}
