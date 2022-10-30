package com.controledeponto.application.exceptions.db;

public class DatabaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DatabaseException (String message) {
        super(message);
    }

}