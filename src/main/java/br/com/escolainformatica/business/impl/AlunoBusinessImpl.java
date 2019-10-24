package br.com.escolainformatica.business.impl;

import br.com.escolainformatica.business.AlunoBusiness;
import br.com.escolainformatica.exception.NotFoundException;
import br.com.escolainformatica.model.Aluno;
import br.com.escolainformatica.model.AlunoTurma;
import br.com.escolainformatica.model.Turma;
import br.com.escolainformatica.repository.AlunoRepository;
import br.com.escolainformatica.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoBusinessImpl implements AlunoBusiness {

    AlunoRepository alunoRepository;
    TurmaRepository turmaRepository;

    @Autowired
    public AlunoBusinessImpl(AlunoRepository alunoRepository, TurmaRepository turmaRepository) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    @Override
    public List<Aluno> findAll(Pageable pageable) {
        return alunoRepository.findAll(pageable).getContent();
    }

    @Override
    public Aluno findOne(Integer id) {
        alunoValidate(id);
        return alunoRepository.findById(id).get();
    }

    @Override
    public List<AlunoTurma> findAllByName(Pageable pageable, String nome){
        List<Aluno> alunos = alunoRepository.findAllByNomeContains(pageable, nome);
        if (alunos == null || alunos.isEmpty())
            throw new NotFoundException("Nenhum aluno foi encontrado com o nome " + nome);

        List<AlunoTurma> alunosTurma = new ArrayList<AlunoTurma>();
        for (Aluno aluno : alunos){
            List<Turma> turmas = turmaRepository.findAllByAluno(aluno.getId());

            if (turmas == null)
                turmas = new ArrayList<>();

            for (Turma turma : turmas){
                turma.setAlunos(null);
                turma.getCurso().setMaterias(null);
            }

            AlunoTurma alunoTurma = new AlunoTurma(aluno, turmas);
            alunosTurma.add(alunoTurma);
        }

        return alunosTurma;
    }

    @Override
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno save(Integer id, Aluno aluno) {
        alunoValidate(id);
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(Integer id) {
        alunoValidate(id);
        alunoRepository.deleteById(id);
    }

    private void alunoValidate(Integer id){
        if (!alunoRepository.existsById(id))
            throw new NotFoundException("Aluno");
    }
}
