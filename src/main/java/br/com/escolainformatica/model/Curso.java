package br.com.escolainformatica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table
public class Curso implements Serializable {
    private static final long serialVersionUID = -7999883071126091092L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @ManyToMany
    @JoinTable(name = "materia_cursos",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_materia")
    )
    private List<Materia> materias;

    @OneToMany(mappedBy = "curso")
    @JsonIgnore
    private List<Turma> turmas;

    public Curso(Integer id, String descricao, List<Materia> materias) {
        this.id = id;
        this.descricao = descricao;
        this.materias = materias;
    }

    public Curso() {
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

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public void addMateria(Materia materia) {
        verificaMaterias();
        materias.add(materia);
    }

    public void removeMateria(Materia materia) {
        verificaMaterias();
        materias.remove(materia);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    private void verificaMaterias(){
        if (materias == null)
            materias = new ArrayList<>();
    }
}
