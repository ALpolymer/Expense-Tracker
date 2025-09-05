package dev.alexpol.expenseTracker.exceptions;
public class AppObjectNotFoundException extends AppGenericException{
    private static final String DEFAULT_CODE = "NotFound";

    AppObjectNotFoundException(String code, String message){
        super(code + DEFAULT_CODE,  message);
    }
}
