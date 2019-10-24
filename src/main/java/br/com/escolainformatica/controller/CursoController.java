package br.com.escolainformatica.controller;

import br.com.escolainformatica.business.CursoBusiness;
import br.com.escolainformatica.exception.Response;
import br.com.escolainformatica.model.Curso;
import br.com.escolainformatica.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cursos")
public class CursoController {

    @Autowired
    CursoBusiness cursoBusiness;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll(@PageableDefault(size = 10) Pageable pageable){
        return ResponseEntity.ok(cursoBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findOne(@PathVariable Integer id){
        return ResponseEntity.ok(cursoBusiness.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody Curso curso){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoBusiness.save(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> save(@PathVariable Integer id, @RequestBody Curso curso){
        return ResponseEntity.ok(cursoBusiness.save(id, curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        cursoBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Operação realizada com sucesso!"));
    }

    @PostMapping("/{id}/materias")
    public ResponseEntity<List<Materia>> addMateria(@PathVariable Integer id, @RequestBody Materia materia){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoBusiness.addMateria(id, materia));
    }

    @DeleteMapping("/{idCurso}/materias/{idMateria}")
    public ResponseEntity<List<Materia>> removeMateria(@PathVariable Integer idCurso, @PathVariable Integer idMateria){
        return ResponseEntity.status(HttpStatus.OK).body(cursoBusiness.removeMateria(idCurso, idMateria));
    }
}
