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
    private int id;

    @Column(nullable = false)
    private String periodo;

    @ManyToOne
    @JoinColumn(name="id_curso", nullable = false)
    private Curso curso;

    @ManyToMany
    @JoinTable(name = "Turma_Aluno",
            joinColumns = @JoinColumn(name = "id_turma", foreignKey = @ForeignKey(name = "Turma_Turma_Aluno_FK")),
            inverseJoinColumns = @JoinColumn(name = "id_aluno", foreignKey = @ForeignKey(name = "Aluno_TurmaAluno_FK")))
    private List<Aluno> alunos;

    public Turma() {
    }

    public Turma(int id, String periodo, Curso curso, List<Aluno> alunos) {
        this.id = id;
        this.periodo = periodo;
        this.curso = curso;
        this.alunos = alunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
