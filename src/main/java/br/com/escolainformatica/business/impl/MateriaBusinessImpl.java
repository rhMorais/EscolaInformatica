package br.com.escolainformatica.business.impl;

import br.com.escolainformatica.business.MateriaBusiness;
import br.com.escolainformatica.exception.NotFoundException;
import br.com.escolainformatica.model.Materia;
import br.com.escolainformatica.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaBusinessImpl implements MateriaBusiness {

    MateriaRepository materiaRepository;

    @Autowired
    public MateriaBusinessImpl(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Override
    public List<Materia> findAll(Pageable pageable) {
        return materiaRepository.findAll(pageable).getContent();
    }

    @Override
    public Materia findOne(int id) {
        return materiaRepository.findById(id).get();
    }

    @Override
    public Materia save(Materia materia) {
        return materiaRepository.save(materia);
    }

    @Override
    public Materia save(int id, Materia materia) {
        if (!materiaRepository.existsById(id))
            throw new NotFoundException();

        materia.setId(id);
        return materiaRepository.save(materia);
    }

    @Override
    public void delete(int id) {
        materiaRepository.deleteById(id);
    }
}
