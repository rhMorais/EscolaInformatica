package br.com.escolainformatica.exception;

import br.com.escolainformatica.model.Professor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestException {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response exception (NotFoundException ex){
        //todo: salvar exception em um log
        return new Response("Dados não encontrados.");
    }

    @ExceptionHandler(ProfessorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Response exception (ProfessorNotFoundException ex){
        //todo: salvar exception em um log
        return new Response("Necessário informar um professor existente para salvar a matéria.");
    }
}
