package nl.belastingdienst.h3;

import org.junit.Test;

public class IncrementorTest {

    @Test
    public void incrementByOne(){
        Incrementor i = new Incrementor();
        i.increment(6);
    }

}
