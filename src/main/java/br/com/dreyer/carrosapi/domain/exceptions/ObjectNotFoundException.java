package br.com.dreyer.carrosapi.domain.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String message){
        super(message);
    }

    public ObjectNotFoundException(Long id, String className){
        super(String.format("The %s id %d not found.", className, id));
    }
}
