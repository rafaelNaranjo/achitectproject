package com.rafaelnarnajo.msone.infrastructure.in.api.dto;

public class InfraestructureException extends RuntimeException {
    public InfraestructureException() {
        super();
    }

    public InfraestructureException(String message) {
        super(message);
    }

    public InfraestructureException(String message, Throwable cause) {
        super(message, cause);
    }
}
