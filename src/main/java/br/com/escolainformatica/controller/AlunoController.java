package br.com.escolainformatica.controller;

import br.com.escolainformatica.business.AlunoBusiness;
import br.com.escolainformatica.exception.Response;
import br.com.escolainformatica.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alunos")
public class AlunoController {

    AlunoBusiness alunoBusiness;

    @Autowired
    public AlunoController(AlunoBusiness alunoBusiness) {
        this.alunoBusiness = alunoBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(@PageableDefault(size = 10) Pageable pageable){
        return ResponseEntity.ok(alunoBusiness.findAll(pageable));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> findAllByName(@PageableDefault(size = 10) Pageable pageable,
                                                     @RequestParam String nome){
        return ResponseEntity.ok(alunoBusiness.findAllByName(pageable, nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findOne(@PathVariable int id){
        return ResponseEntity.ok(alunoBusiness.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(alunoBusiness.save(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> put(@PathVariable int id, @RequestBody Aluno aluno){
        return ResponseEntity.ok(alunoBusiness.save(id, aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        alunoBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Materia excluída com sucesso"));
    }
}
