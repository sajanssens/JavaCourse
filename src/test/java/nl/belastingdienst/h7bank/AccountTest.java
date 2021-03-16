package nl.belastingdienst.h7bank;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void whenDepositBalanceIncreases(){
        Account acc = new Account("123456", 100f, 3f);
        acc.deposit(100);
        Assert.assertTrue(acc.getBalance() == 200  );
    }

    @Test
    public void whenWithDrawBalanceDecreases(){
        Account acc = new Account("123456", 100f, 3f);
        acc.withdraw(30);
        Assert.assertTrue(acc.getBalance() == 70 );
    }

    @Test
    public void whenCalcInterest(){
        Account acc = new Account("123456", 100f, 3f);
        float interest = acc.calcInterest();
        Assert.assertTrue(interest == 3f );
    }

    @Test
    public void whenGetInterestRate(){
        Account acc = new Account("123456", 100f, 3f);
        float interestRate = acc.getInterestRate();
        Assert.assertTrue(interestRate == 3f );
    }

    @Test
    public void whenSetInterestRate(){
        Account acc = new Account("123456", 100f, 3f);
        acc.setInterestRate(4f);
        Assert.assertTrue(acc.getInterestRate() == 4f );
    }

    @Test
    public void whenGetBalance(){
        Account acc = new Account("123456", 100f, 3f);
        float interestRate = acc.getInterestRate();
        Assert.assertTrue(interestRate == 3f );
    }




    @Test
    public void testAccount(){
        Account acc = new Account("123434", 0f, 3f);
        System.out.printf("Initial balance: %.2f", acc.getBalance());
        acc.deposit(100.45f);
        System.out.printf("\nCurrent balance: %.2f", acc.getBalance());

        // withdraw
        float withdrawAmount = 17.55f;
        boolean success = acc.withdraw(withdrawAmount);
        System.out.printf("\nWithdrawing: %.2f", withdrawAmount);
        if(success) {
            System.out.printf("\nCurrent balance: %.2f", acc.getBalance());
        }
        else{
            System.out.println("\nBalance insufficient");
        }

        // withdraw too much
        withdrawAmount = 230.22f;
        success = acc.withdraw(withdrawAmount);
        System.out.printf("\nWithdrawing: %.2f", withdrawAmount);
        if(success) {
            System.out.printf("\nCurrent balance: %.2f", acc.getBalance());
        }
        else{
            System.out.println("\nBalance insufficient");
        }

        // calc interest
        System.out.printf("\nInterest rate %.2f, balance %.2f, interest: %.2f ", acc.getInterestRate(), acc.getBalance(), acc.calcInterest());

    }
}
