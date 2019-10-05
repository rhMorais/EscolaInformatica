package br.com.escolainformatica.business;

import br.com.escolainformatica.model.Materia;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MateriaBusiness {
    List<Materia> findAll(Pageable pageable);
    Materia findOne(int id);
    Materia save(Materia materia);
    Materia save(int id, Materia materia);
    void delete(int id);
}
