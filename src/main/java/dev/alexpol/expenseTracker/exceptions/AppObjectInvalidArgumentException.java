package dev.alexpol.expenseTracker.exceptions;

public class AppObjectInvalidArgumentException extends AppGenericException{
    private static final String DEFAULT_CODE = "InvalidArgument";

    AppObjectInvalidArgumentException(String code, String message){
        super(code + DEFAULT_CODE, message);

    }
}
