package nl.belastingdienst.h7;

public class PersonDiedException extends Exception {
    private String code;

    public PersonDiedException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
