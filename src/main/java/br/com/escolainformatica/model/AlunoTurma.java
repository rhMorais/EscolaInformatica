package br.com.escolainformatica.model;

import java.util.List;

public class AlunoTurma {

    private Aluno aluno;
    private List<Turma> turma;

    public AlunoTurma(Aluno aluno, List<Turma> turma) {
        this.aluno = aluno;
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }
}
