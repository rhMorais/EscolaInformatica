package br.com.escolainformatica.business;

import br.com.escolainformatica.model.Curso;
import br.com.escolainformatica.model.Materia;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CursoBusiness {
    List<Curso> findAll(Pageable pageable);
    Curso findOne(Integer id);
    Curso save(Curso curso);
    Curso save(Integer id, Curso curso);
    void delete(Integer id);
    List<Materia> addMateria(Integer id, Materia materia);
    List<Materia> removeMateria(Integer idCurso, Integer idMateria);
}
