package br.com.escolainformatica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestException {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response exception (NotFoundException ex){
        if (ex.getEntityName() == null || ex.getEntityName().isEmpty())
            return new Response("Dados não encontrados!");

        return new Response(ex.getEntityName() + " não encontrado(a).");
    }

    @ExceptionHandler(ProfessorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Response exception (ProfessorNotFoundException ex){
        return new Response("Necessário informar um professor existente para salvar a matéria.");
    }

    @ExceptionHandler(MateriasNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Response exception (MateriasNotFoundException ex){
        return new Response("Necessário informar uma ou mais matérias para inserir um curso.");
    }
}
