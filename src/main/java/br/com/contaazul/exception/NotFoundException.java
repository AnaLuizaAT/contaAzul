package br.com.contaazul.exception;

public class NotFoundException extends Exception {

    public NotFoundException() {
    }

    public NotFoundException(final String message) {
        super(message);
    }
}