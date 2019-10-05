package br.com.escolainformatica.business;

import br.com.escolainformatica.model.Materia;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MateriaBusiness {
    List<Materia> findAll(Pageable pageable);
    Materia findOne(int id);
    Materia save(Materia professor);
    Materia save(int id, Materia professor);
    void delete(int id);
}
