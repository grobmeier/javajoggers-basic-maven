package com.accenture.javajoggers.pets.db;

public class AnimalRepositoryException extends Exception {

    public AnimalRepositoryException() {
    }

    public AnimalRepositoryException(String message) {
        super(message);
    }

    public AnimalRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
