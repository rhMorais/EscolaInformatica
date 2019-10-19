package br.com.escolainformatica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Turma implements Serializable {
    private static final long serialVersionUID = -2432885787219557170L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String periodo;

    @ManyToOne
    @JoinColumn(name="id_curso", nullable = false)
    private Curso curso;

    @ManyToMany
    @JoinTable(name = "aluno_turmas",
            joinColumns = @JoinColumn(name = "id_aluno"),
            inverseJoinColumns = @JoinColumn(name = "id_turma"))
    private List<Aluno> alunos;

    public Turma() {
    }

    public Turma(Integer id, String periodo, Curso curso, List<Aluno> alunos) {
        this.id = id;
        this.periodo = periodo;
        this.curso = curso;
        this.alunos = alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
