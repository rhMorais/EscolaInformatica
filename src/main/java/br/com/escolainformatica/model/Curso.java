package br.com.escolainformatica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Curso implements Serializable {
    private static final long serialVersionUID = -7999883071126091092L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String descricao;

    @ManyToMany
    @JoinTable( name = "Curso_Materia",
                joinColumns = @JoinColumn(  name = "id_curso",
                                            foreignKey = @ForeignKey(name = "Curso_Curso_Materia_FK")),
                inverseJoinColumns = @JoinColumn(   name = "id_materia",
                                                    foreignKey = @ForeignKey(name="Materia_Curso_Materia_FK")))
    private List<Materia> materias;

    @OneToMany(mappedBy = "curso")
    private List<Turma> turmas;

    public Curso(int id, String descricao, List<Materia> materias) {
        this.id = id;
        this.descricao = descricao;
        this.materias = materias;
    }

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Turma> getTurmas() {
        return turmas;
    }
}
