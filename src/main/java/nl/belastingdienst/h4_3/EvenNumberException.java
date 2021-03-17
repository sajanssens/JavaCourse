package nl.belastingdienst.h4_3;

/**
 * Even number Exception
 * https://www.baeldung.com/java-new-custom-exception
 */
public class EvenNumberException extends Exception{
    public EvenNumberException(String errorMessage){
        super(errorMessage);
    }
}
