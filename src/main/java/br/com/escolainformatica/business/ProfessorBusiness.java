package br.com.escolainformatica.business;

import br.com.escolainformatica.model.Professor;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProfessorBusiness {
    List<Professor> findAll(Pageable pageable);
    Professor findOne(int id);
    Professor save(Professor professor);
    Professor save(int id, Professor professor);
    void delete(int id);
}
