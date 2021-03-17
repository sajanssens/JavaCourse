package nl.belastingdienst.h4;

import org.junit.Assert;
import org.junit.Test;


public class ElevenProofTest{

    @Test
    public void whenAccountNumberIsValidItShouldPassThe11Proof() {

        // when account is valid
        ElevenProof p11 = new ElevenProof("736160221");

        // then it should pass 11-proof
        Assert.assertTrue(p11.execute());
    }

    @Test
    public void whenAccountNumberIsInValidItShouldNotPassThe11Proof() {

        // when account is valid
        ElevenProof p11 = new ElevenProof("111111111");

        // then it should not pass 11-proof
        Assert.assertFalse(p11.execute());
    }

}