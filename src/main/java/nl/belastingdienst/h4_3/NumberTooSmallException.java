package nl.belastingdienst.h4_3;

public class NumberTooSmallException extends RuntimeException{
    public NumberTooSmallException(String errorMessage){
        super(errorMessage);
    }
}
