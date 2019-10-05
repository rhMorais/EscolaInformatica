package br.com.escolainformatica.business.impl;

import br.com.escolainformatica.business.ProfessorBusiness;
import br.com.escolainformatica.exception.NotFoundException;
import br.com.escolainformatica.model.Professor;
import br.com.escolainformatica.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfessorBusinessImpl implements ProfessorBusiness {

    ProfessorRepository professorRepository;

    @Autowired
    public ProfessorBusinessImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> findAll(Pageable pageable) {
        return professorRepository.findAll(pageable).getContent();
    }

    @Override
    public Professor findOne(int id) {
        return professorRepository.findById(id).get();
    }

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor save(int id, Professor professor){
        if (!professorRepository.existsById(id))
            throw new NotFoundException();

        professor.setId(id);
        return professorRepository.save(professor);
    }

    @Override
    public void delete(int id) {
        professorRepository.deleteById(id);
    }
}
