package com.example.Task.Monitor.Exceptions;

public class NoIdExistsException extends RuntimeException {

    public NoIdExistsException() {
    }

    public NoIdExistsException(String msg) {
        super(msg);
    }
}
