package nl.belastingdienst.h4;

import org.junit.Test;

public class DataGetterTest {
    @Test
    public void DoElevenProof(){

        DataGetter dg = new DataGetter("Account Number");
        // @TODO check on numeric
        String input = dg.getData();

    }

}
