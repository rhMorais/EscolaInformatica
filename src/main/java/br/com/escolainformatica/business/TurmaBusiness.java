package br.com.escolainformatica.business;

import br.com.escolainformatica.model.Turma;
import br.com.escolainformatica.model.Aluno;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface TurmaBusiness {
    List<Turma> findAll(Pageable pageable);
    Turma findOne(Integer id);
    Turma save(Turma turma);
    Turma save(Integer id, Turma turma);
    void delete(Integer id);

    List<Aluno> addAlunos(Integer idTurma, List<Aluno> alunos);
    List<Aluno> removeAluno(Integer idTurma, Integer idAluno);
}
