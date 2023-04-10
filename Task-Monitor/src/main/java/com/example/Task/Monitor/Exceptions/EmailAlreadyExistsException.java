package com.example.Task.Monitor.Exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(){}

    public EmailAlreadyExistsException(String msg) {
        super (msg);
    }
}
