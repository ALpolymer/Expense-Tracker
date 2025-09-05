package dev.alexpol.expenseTracker.exceptions;

public class AppObjectNotAuthorizedException extends AppGenericException{
    private static final String DEFAULT_CODE = "NotAuthorized";

    AppObjectNotAuthorizedException(String code, String message){
        super(code + DEFAULT_CODE, message);
    }
}
