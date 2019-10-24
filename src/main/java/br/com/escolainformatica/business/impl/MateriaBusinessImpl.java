package br.com.escolainformatica.business.impl;

import br.com.escolainformatica.business.MateriaBusiness;
import br.com.escolainformatica.exception.NotFoundException;
import br.com.escolainformatica.exception.ProfessorNotFoundException;
import br.com.escolainformatica.model.Materia;
import br.com.escolainformatica.model.Professor;
import br.com.escolainformatica.repository.MateriaRepository;
import br.com.escolainformatica.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaBusinessImpl implements MateriaBusiness {

    MateriaRepository materiaRepository;
    ProfessorRepository professorRepository;

    @Autowired
    public MateriaBusinessImpl(MateriaRepository materiaRepository, ProfessorRepository professorRepository) {
        this.materiaRepository = materiaRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Materia> findAll(Pageable pageable) {
        return materiaRepository.findAll(pageable).getContent();
    }

    @Override
    public Materia findOne(Integer id) {
        materiaValidate(id);
        return materiaRepository.findById(id).get();
    }

    @Override
    public Materia save(Materia materia) {
        validaProfessor(materia.getProfessor());
        return materiaRepository.save(materia);
    }

    @Override
    public Materia save(Integer id, Materia materia) {
        materiaValidate(id);
        validaProfessor(materia.getProfessor());
        materia.setId(id);
        return materiaRepository.save(materia);
    }

    @Override
    public void delete(Integer id) {
        materiaRepository.deleteById(id);
    }

    private void materiaValidate(Integer id){
        if (!materiaRepository.existsById(id))
            throw new NotFoundException("Matéria");
    }

    private void validaProfessor(Professor professor){
        if (professor == null || !professorRepository.existsById(professor.getId()))
            throw new ProfessorNotFoundException();
    }
}
