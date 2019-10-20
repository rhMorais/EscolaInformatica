package br.com.escolainformatica.controller;

import br.com.escolainformatica.business.TurmaBusiness;
import br.com.escolainformatica.exception.Response;
import br.com.escolainformatica.model.Turma;
import br.com.escolainformatica.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/turmas")
public class TurmaController {

    @Autowired
    TurmaBusiness turmaBusiness;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll(@PageableDefault(size = 10) Pageable pageable){
        return ResponseEntity.ok(turmaBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findOne(@PathVariable Integer id){
        return ResponseEntity.ok(turmaBusiness.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Turma> save(@RequestBody Turma turma){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(turmaBusiness.save(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> save(@PathVariable Integer id, @RequestBody Turma turma){
        return ResponseEntity.ok(turmaBusiness.save(id, turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        turmaBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.OK);
    }

    @PostMapping("/{id}/alunos")
    public ResponseEntity<List<Aluno>> addAlunos(@PathVariable Integer id, @RequestBody List<Aluno> alunos){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(turmaBusiness.addAlunos(id, alunos));
    }

    @DeleteMapping("/{idTurma}/alunos/{idAluno}")
    public ResponseEntity<List<Aluno>> removeAluno(@PathVariable Integer idTurma, @PathVariable Integer idAluno){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(turmaBusiness.removeAluno(idTurma, idAluno));
    }
}
