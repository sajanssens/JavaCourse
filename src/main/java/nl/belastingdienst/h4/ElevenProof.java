package nl.belastingdienst.h4;

public class ElevenProof {

    private String number;

    /**
     * Constructor
     * Preconditions: length 9 or 10, only digits
     * @param number String number to check
     */
    public ElevenProof(String number){
        this.number = number;
    }

    /**
     * Execute the eleven proof
     * @return true if compliant
     */
    public boolean execute(){
        int i, digit;
        int checkNo = 0;
        int multiplier = this.number.length();

        for( i = 0 ; i<this.number.length(); i++){
            digit = Integer.parseInt(this.number.substring(i,i+1));
            checkNo += digit * multiplier;
            multiplier--;
        }

        return checkNo%11 == 0;
    }
}
