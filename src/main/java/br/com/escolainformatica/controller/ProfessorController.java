package br.com.escolainformatica.controller;

import br.com.escolainformatica.business.ProfessorBusiness;
import br.com.escolainformatica.exception.Response;
import br.com.escolainformatica.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/professores")
public class ProfessorController {

    ProfessorBusiness professorBusiness;

    @Autowired
    public ProfessorController(ProfessorBusiness professorBusiness) {
        this.professorBusiness = professorBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> findAll(@PageableDefault(size = 10)Pageable pageable){
        return ResponseEntity.ok(professorBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findOne(@PathVariable int id){
        return ResponseEntity.ok(professorBusiness.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Professor> save(@RequestBody Professor professor){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(professorBusiness.save(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> put(@PathVariable int id, @RequestBody Professor professor){
        return ResponseEntity.ok(professorBusiness.save(id, professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        professorBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Professor excluído com sucesso");
    }
}
