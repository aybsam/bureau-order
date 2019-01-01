package com.lismart.smartregie.exception;

public class EmailExistsException extends Exception {

    public EmailExistsException(String email) {
        super("Il y a déja un utilisateur avec cette adresse E-Mail: " + email);
    }
}
