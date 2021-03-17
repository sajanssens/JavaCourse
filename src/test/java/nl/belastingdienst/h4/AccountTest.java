package nl.belastingdienst.h4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AccountTest {

    private Account account;

    @Before
    public void setup(){
        this.account = new Account();
    }

    @Test
    public void whenAccountNumberIsValidItShouldPassValidation() {

        // when account number is valid
        account.setNumber("736160221");

        // then it should pass validation
        Assert.assertTrue(account.validate());
        Assert.assertTrue(account.getState() == AccountState.ok);

    }

    @Test
    public void whenAccountNumberIsNotValidatedItShouldHAveStateNotValidated() {

        // when account number is not yet validited
        account.setNumber("736160221");

        // then it should have state not validated
        Assert.assertTrue(account.getState() == AccountState.notValidated);

    }

    @Test
    public void whenAccountNumberIsTooLongItShouldFailValidation() {

        // when account number is too long
        account.setNumber("73616022194");

        // then it should fail validation
        Assert.assertFalse(account.validate());
        Assert.assertTrue(account.getState() == AccountState.lengthError);

    }

    @Test
    public void whenAccountNumberIsTooShortItShouldFailValidation() {

        // when account number is too short
        account.setNumber("73616022");

        // then it should fail validation
        Assert.assertFalse(account.validate());
        Assert.assertTrue(account.getState() == AccountState.lengthError);

    }

    @Test
    public void whenAccountNumberIsZeroItShouldFailValidation() {

        // when account number is zero
        account.setNumber("000000000");

        // then it should fail validation
        Assert.assertFalse(account.validate());
        Assert.assertTrue(account.getState() == AccountState.rangeError);
    }

    @Test
    public void whenAccountNumberIsNotNumericItShouldFailValidation() {

        // when account number is not numeric
        account.setNumber("1234R45H5");

        // then it should fail validation
        Assert.assertFalse(account.validate());
        Assert.assertTrue(account.getState() == AccountState.numericError);
    }

    @Test
    public void whenAccountNumberIsNot11ProofItShouldFailValidation() {

        // when account number is not numeric
        account.setNumber("123456788");

        // then it should fail validation
        Assert.assertFalse(account.validate());
        Assert.assertTrue(account.getState() == AccountState.proof11Error);
    }

    @Test
    public void whenGetStateItShouldReflectCurrentState(){
        Assert.assertTrue(account.getState() == AccountState.notValidated);
    }
}