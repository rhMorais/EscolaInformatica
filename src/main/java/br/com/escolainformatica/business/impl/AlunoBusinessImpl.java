package br.com.escolainformatica.business.impl;

import br.com.escolainformatica.business.AlunoBusiness;
import br.com.escolainformatica.exception.NotFoundException;
import br.com.escolainformatica.model.Aluno;
import br.com.escolainformatica.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoBusinessImpl implements AlunoBusiness {

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public List<Aluno> findAll(Pageable pageable) {
        return alunoRepository.findAll(pageable).getContent();
    }

    @Override
    public Aluno findOne(Integer id) {
        if (!alunoRepository.existsById(id))
            throw new NotFoundException();

        return alunoRepository.findById(id).get();
    }

    @Override
    public List<Aluno> findAllByName(Pageable pageable, String nome){
        return alunoRepository.findAllByNomeContains(pageable, nome);
    }

    @Override
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno save(Integer id, Aluno aluno) {
        if (!alunoRepository.existsById(id))
            throw new NotFoundException();

        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(Integer id) {
        alunoRepository.deleteById(id);
    }
}
