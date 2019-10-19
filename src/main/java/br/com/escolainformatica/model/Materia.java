package br.com.escolainformatica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Materia implements Serializable {
    private static final long serialVersionUID = -9033349492959085190L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name="id_professor",
                foreignKey = @ForeignKey(name = "Professor_Materia_FK"),
                nullable = false)
    private Professor professor;

    @ManyToMany(mappedBy = "materias")
    @JsonIgnore
    private List<Curso> cursos;

    public Materia(Integer id, String descricao, Professor professor) {
        this.id = id;
        this.descricao = descricao;
        this.professor = professor;
    }

    public Materia(Integer id){
        this.id = id;
    }

    public Materia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Curso> getCursos() {
        return cursos;
    }
}
