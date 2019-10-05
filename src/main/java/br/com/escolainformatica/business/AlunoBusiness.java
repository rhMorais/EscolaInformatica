package br.com.escolainformatica.business;

import br.com.escolainformatica.model.Aluno;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface AlunoBusiness {
    List<Aluno> findAll(Pageable pageable);
    Aluno findOne(int id);
    List<Aluno> findAllByName(Pageable pageable, String nome);
    Aluno save(Aluno aluno);
    Aluno save(int id, Aluno aluno);
    void delete(int id);
}
