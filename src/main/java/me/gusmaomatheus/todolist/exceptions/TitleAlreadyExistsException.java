package me.gusmaomatheus.todolist.exceptions;

public class TitleAlreadyExistsException extends RuntimeException {

    public TitleAlreadyExistsException(String message) {
        super(message);
    }
}
