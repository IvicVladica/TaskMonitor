package com.example.Task.Monitor.Exceptions;

public class NoIdExistsException extends RuntimeException {

    private String message;

    public NoIdExistsException() {
    }

    public NoIdExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
