package br.com.escolainformatica.exception;

public class NotFoundException extends RuntimeException{
    private String entityName;

    public NotFoundException(String entityName){ this.entityName = entityName; }
    public NotFoundException() {}

    public String getEntityName() {
        return entityName;
    }
}
