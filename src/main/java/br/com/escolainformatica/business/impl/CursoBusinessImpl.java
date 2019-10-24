package br.com.escolainformatica.business.impl;

import br.com.escolainformatica.business.CursoBusiness;
import br.com.escolainformatica.business.MateriaBusiness;
import br.com.escolainformatica.exception.MateriasNotFoundException;
import br.com.escolainformatica.exception.NotFoundException;
import br.com.escolainformatica.model.Curso;
import br.com.escolainformatica.model.Materia;
import br.com.escolainformatica.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoBusinessImpl implements CursoBusiness {

    CursoRepository cursoRepository;
    MateriaBusiness materiaBusiness;

    @Autowired
    public CursoBusinessImpl(CursoRepository cursoRepository, MateriaBusiness materiaBusiness) {
        this.cursoRepository = cursoRepository;
        this.materiaBusiness = materiaBusiness;
    }

    @Override
    public List<Curso> findAll(Pageable pageable) { return cursoRepository.findAll(pageable).getContent(); }

    @Override
    public Curso findOne(Integer id) {
        cursoValidate(id);
        return cursoRepository.findById(id).get();
    }

    @Override
    public Curso save(Curso curso) {
        if (curso.getMaterias() == null || curso.getMaterias().isEmpty())
            throw new MateriasNotFoundException();

        return cursoRepository.save(curso);
    }

    @Override
    public Curso save(Integer id, Curso curso) {
        cursoValidate(id);
        curso.setId(id);
        return cursoRepository.save(curso);
    }

    @Override
    public void delete(Integer id) {
        cursoValidate(id);
        cursoRepository.deleteById(id);
    }

    @Override
    public List<Materia> addMateria(Integer id, Materia materia) {
        Curso curso = findOne(id);
        Materia materiaDb = materiaBusiness.findOne(materia.getId());
        curso.addMateria(materiaDb);
        return cursoRepository.save(curso).getMaterias();
    }

    @Override
    public List<Materia> removeMateria(Integer idCurso, Integer idMateria) {
        Curso curso = findOne(idCurso);
        Materia materia = materiaBusiness.findOne(idMateria);
        curso.removeMateria(materia);
        return cursoRepository.save(curso).getMaterias();
    }

    private void cursoValidate(Integer id){
        if (!cursoRepository.existsById(id))
            throw new NotFoundException("Curso");
    }
}
