package nl.belastingdienst.h7bank;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void whenDepositBalanceIncreases(){
        Account acc = new Account("123456", 100f, 3f);
        acc.deposit(100);
        Assert.assertEquals(200, acc.getBalance(), 0.0);
    }

    @Test
    public void whenWithDrawBalanceDecreases(){
        Account acc = new Account("123456", 100f, 3f);
        boolean succeeded = acc.withdraw(30);
        Assert.assertTrue(succeeded);
        Assert.assertEquals(70, acc.getBalance(), 0.0);
    }

    @Test
    public void whenInterestCalculatedFor5YearsResultmustBeCorrect(){
        Account acc = new Account("123456", 1000f, 10f);
        Assert.assertEquals(1500f, acc.calcInterest(5), 0.0);
    }

    @Test
    public void whenGetInterestRate(){
        Account acc = new Account("123456", 100f, 3f);
        float interestRate = acc.getInterestRate();
        Assert.assertEquals(3f, interestRate, 0.0);
    }

    @Test
    public void whenSetInterestRate(){
        Account acc = new Account("123456", 100f, 3f);
        acc.setInterestRate(4f);
        Assert.assertEquals(4f, acc.getInterestRate(), 0.0);
    }

    @Test
    public void whenGetBalance(){
        Account acc = new Account("123456", 100f, 3f);
        Assert.assertEquals(100f, acc.getBalance(), 0.0);
    }

    @Test
    public void whenSetBalance(){
        Account acc = new Account("123456", 100f, 3f);
        acc.setBalance(230f);
        Assert.assertFalse(acc.getBalance() != 230f);
    }

    @Test
    public void whenGetBankNr(){
        Account acc = new Account("123456", 100f, 3f);
        Assert.assertSame("123456", acc.getBankNr());
    }

    @Test
    public void whenSetBankNr(){
        Account acc = new Account("123456", 100f, 3f);
        acc.setBankNr("333333");
        Assert.assertEquals("333333", acc.getBankNr());

    }

    @Test
    public void whenOverDrawAccount(){
        Account acc = new Account("123456", 100f, 3f);
        boolean succeeded = acc.withdraw(300f);
        Assert.assertFalse(succeeded);
    }


}
