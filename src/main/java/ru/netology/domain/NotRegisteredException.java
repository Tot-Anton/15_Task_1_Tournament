package ru.netology.domain;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String p) {
        super(p);
    }

}
