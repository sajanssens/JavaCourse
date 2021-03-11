package nl.belastingdienst.h3;

import org.junit.Test;

public class BitShifterTest {

    @Test
    public void shift(){
        BitShifter bs = new BitShifter();
        bs.shift();
    }

    @Test
    public void sum(){
        BitShifter bs = new BitShifter();
        bs.bitSum();
    }

    @Test
    public void whenHoursAddedToStartTime(){
        BitShifter bs = new BitShifter();
        System.out.printf("\nNew time is %s o'clock",bs.calcTimeAfterHours(23, 80));
    }

    @Test
    public void whenMaxValues(){
        BitShifter bs = new BitShifter();
        bs.maxValues();
    }

}
