package br.com.escolainformatica.business.impl;

import br.com.escolainformatica.business.TurmaBusiness;
import org.springframework.stereotype.Service;
import br.com.escolainformatica.business.AlunoBusiness;
import br.com.escolainformatica.exception.NotFoundException;
import br.com.escolainformatica.model.Turma;
import br.com.escolainformatica.model.Aluno;
import br.com.escolainformatica.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class TurmaBusinessImpl implements TurmaBusiness {

    TurmaRepository turmaRepository;
    AlunoBusiness alunoBusiness;

    @Autowired
    public TurmaBusinessImpl(TurmaRepository turmaRepository, AlunoBusiness alunoBusiness) {
        this.turmaRepository = turmaRepository;
        this.alunoBusiness = alunoBusiness;
    }

    @Override
    public List<Turma> findAll(Pageable pageable) { return turmaRepository.findAll(pageable).getContent(); }

    @Override
    public Turma findOne(Integer id) {
        turmaValidate(id);
        return turmaRepository.findById(id).get();
    }

    @Override
    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public Turma save(Integer id, Turma turma) {
        turmaValidate(id);
        turma.setId(id);
        return turmaRepository.save(turma);
    }

    @Override
    public void delete(Integer id) {
        turmaRepository.deleteById(id);
    }

    @Override
    public List<Aluno> addAlunos(Integer id, List<Aluno> alunos) {
        Turma turma = findOne(id);
        
        for(Aluno aluno : alunos) {
            Aluno alunoDb = alunoBusiness.findOne(aluno.getId());
            turma.addAluno(alunoDb);    
        }        
        
        return turmaRepository.save(turma).getAlunos();
    }

    @Override
    public List<Aluno> removeAluno(Integer idTurma, Integer idAluno) {
        Turma turma = findOne(idTurma);
        Aluno aluno = alunoBusiness.findOne(idAluno);
        turma.removeAluno(aluno);
        return turmaRepository.save(turma).getAlunos();
    }

    private void turmaValidate(Integer id){
        if (!turmaRepository.existsById(id))
            throw new NotFoundException("Turma");
    }
}
