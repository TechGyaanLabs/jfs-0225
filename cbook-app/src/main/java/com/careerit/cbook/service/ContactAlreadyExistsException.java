package com.careerit.cbook.service;

public class ContactAlreadyExistsException extends RuntimeException {

    public ContactAlreadyExistsException(String message) {
        super(message);
    }

    public ContactAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
