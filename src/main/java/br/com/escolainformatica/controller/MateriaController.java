package br.com.escolainformatica.controller;


import br.com.escolainformatica.business.MateriaBusiness;
import br.com.escolainformatica.exception.Response;
import br.com.escolainformatica.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/materias")
public class MateriaController {

    @Autowired
    MateriaBusiness materiaBusiness;

    @GetMapping
    public ResponseEntity<List<Materia>> findAll(@PageableDefault(size = 10) Pageable pageable){
        return ResponseEntity.ok(materiaBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> findOne(@PathVariable Integer id){
        return ResponseEntity.ok(materiaBusiness.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Materia> save(@RequestBody Materia materia){
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaBusiness.save(materia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> save(@PathVariable Integer id, @RequestBody Materia materia){
        return ResponseEntity.ok(materiaBusiness.save(id, materia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        materiaBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Operação realizada com sucesso!"));
    }
}
