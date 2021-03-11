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
        System.out.printf("\nResult of shift is %s", j);
    }

    public void bitSum(){
        System.out.printf("\nResult of bit sum is %s",0b1010 + 0b100);
    }

    public int calcTimeAfterHours(int startTime, int hours){
        return (startTime + hours) % (int)24;
    }

    public void maxValues(){

        System.out.printf("\nint maxvalue %s", Integer.MAX_VALUE);
        System.out.printf("\nint minvalue %s", Integer.MIN_VALUE);

        System.out.printf("\nlong maxvalue %s", Long.MAX_VALUE);
        System.out.printf("\nlong minvalue %s", Long.MIN_VALUE);

        System.out.printf("\nbyte maxvalue %s", Byte.MAX_VALUE);
        System.out.printf("\nbyte minvalue %s" , Byte.MIN_VALUE);

        System.out.printf("\nfloat maxvalue %s", Float.MAX_VALUE);
        System.out.printf("\nfloat minvalue %s", Float.MIN_VALUE);

    }

}
