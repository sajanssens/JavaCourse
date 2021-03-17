package nl.belastingdienst.h4_3;

public class TooManyErrorsException extends RuntimeException{
    public TooManyErrorsException(String errorMessage){
        super(errorMessage);
    }
}

