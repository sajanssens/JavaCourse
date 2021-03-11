package nl.belastingdienst.h3;

public class BitShifter {
    public void shift(){
        int i = 3;
        int j = i < 3 ? i++ + ++i : ++i >>> 1;
        /**
         * i !< 3 dus 2e deel uitvoeren ++i >>>1
         * ++i hoogt op voorafgaand bewerking dus 4 >>> 1
         * 0100 >>> 1   =>  0010
         * Dus 2 :)
         */
        System.out.printf("Result of shift is %s", j);
    }

    public void bitSum(){
        System.out.printf("Result of bit sum is %s",0b1010 + 0b100);
    }
}
