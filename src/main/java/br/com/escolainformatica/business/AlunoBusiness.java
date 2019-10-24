package br.com.escolainformatica.business;

import br.com.escolainformatica.model.Aluno;
import br.com.escolainformatica.model.AlunoTurma;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface AlunoBusiness {
    List<Aluno> findAll(Pageable pageable);
    Aluno findOne(Integer id);
    List<AlunoTurma> findAllByName(Pageable pageable, String nome);
    Aluno save(Aluno aluno);
    Aluno save(Integer id, Aluno aluno);
    void delete(Integer id);
}
