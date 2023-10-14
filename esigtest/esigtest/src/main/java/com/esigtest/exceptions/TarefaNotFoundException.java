package com.esigtest.exceptions;

public class TarefaNotFoundException extends RuntimeException {

    public TarefaNotFoundException(String message) {
        super(message);
    }

    public TarefaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
