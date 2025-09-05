package dev.alexpol.expenseTracker.exceptions;

import lombok.Getter;

@Getter
public class AppGenericException extends Exception{
    private final String code;

    AppGenericException(String code, String message){
        super(message);
        this.code = code;
    }
}
