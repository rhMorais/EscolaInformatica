package br.com.escolainformatica.model;

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
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Date data_nascimento;

    @Column(nullable = false)
    private double cpf;

    @ManyToMany(mappedBy = "alunos", fetch = FetchType.LAZY)
    private List<Turma> turmas;

    public Aluno(int id, String nome, Date data_nascimento, double cpf) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
    }

    public Aluno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
