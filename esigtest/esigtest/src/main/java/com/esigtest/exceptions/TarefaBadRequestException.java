package com.esigtest.exceptions;

public class TarefaBadRequestException extends RuntimeException {

    public TarefaBadRequestException(String message) {
        super(message);
    }

    public TarefaBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}

