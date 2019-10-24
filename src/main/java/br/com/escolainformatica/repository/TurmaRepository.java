package br.com.escolainformatica.repository;

import br.com.escolainformatica.model.Aluno;
import br.com.escolainformatica.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
    @Query(value = "select t.*\n" +
                    "\tfrom escolaInformatica.turma t \n" +
                    "\t\tinner join escolaInformatica.aluno_turmas  alt\n" +
                    "\t\t\ton alt.id_turma = t.id\n" +
                    "\twhere alt.id_aluno = ?1", nativeQuery = true)
    List<Turma> findAllByAluno(Integer idAluno);
}
