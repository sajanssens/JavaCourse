package nl.belastingdienst.h7bank;

import org.junit.Test;

public class AccountTest {
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
