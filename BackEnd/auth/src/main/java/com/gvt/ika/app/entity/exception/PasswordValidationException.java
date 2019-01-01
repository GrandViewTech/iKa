package com.gvt.ika.app.entity.exception;

public class PasswordValidationException extends Exception {

    private static String info ="";

    static {
        info+="Validation Criteria ";
        info +="^                       # start-of-string \n";
        info +="( ? =.*[0 - 9])         #a digit must occur at least once \n";
        info +="( ? =.*[a - z])         #a lower case letter must occur at least once \n";
        info +="( ? =.*[A - Z])         #an upper case letter must occur at least once \n";
        info +="( ? =.*[@#$ % ^&+=])    #a special character must occur at least once \n";
        info +="( ? =\\S + $)           #no whitespace allowed in the entire string \n";
        info +=" . {8,}                 #anything, at least eight places though \n";
        info +="$                       #end - of - string \n";

    }
    public PasswordValidationException() {
        super();
    }

    public PasswordValidationException(String message) {
        super(info +message);
    }

    public PasswordValidationException(String message, Throwable cause) {
        super(info +message, cause);
    }

    public PasswordValidationException(Throwable cause) {
        super(cause);
    }

    protected PasswordValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(info +message, cause, enableSuppression, writableStackTrace);
    }
}
