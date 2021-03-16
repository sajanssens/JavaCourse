package nl.belastingdienst.h7bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class BankTest {

    Bank bank;
    Map<String, Account> accounts;

    @Before
    public void setup(){

        bank = new Bank();
        bank.addAccount(new Account("123456", 100f, 3f));
        bank.addAccount(new Account("234567", 200f, 3f));
        accounts = bank.getAccounts();

    }

    @Test
    public void whenAccountAddedAccountIsAddedToBank(){

        bank.addAccount(new Account("666666", 100f, 3f));

        Assert.assertTrue(bank.getAccounts().containsKey("666666"));

    }

    @Test
    public void whenTransferFromAccountBalanceIsDecreasedToAccountBalanceIsIncreased(){
        // given
        // .. see Before

        // when
        bank.transfer("123456", "234567", 50f);

        // then
        Assert.assertTrue(accounts.get("123456").getBalance() == 50);
        Assert.assertTrue(accounts.get("234567").getBalance() == 250);

    }

    @Test
    public void whenTransferTooMuchFromAccountBalanceIsNotDecreasedToAccountBalanceIsNotIncreased(){
        // given
        // ..

        // when
        bank.transfer("123456", "234567", 500f);

        // then
        Assert.assertTrue(accounts.get("123456").getBalance() == 100);
        Assert.assertTrue(accounts.get("234567").getBalance() == 200);

    }

    @Test
    public void whenTransferFromNonExistingAccountBalancesAreNotChanged(){
        // given
        // ..

        // when
        bank.transfer("XYZ456", "234567", 5f);

        // then
        Assert.assertTrue(accounts.get("123456").getBalance() == 100);
        Assert.assertTrue(accounts.get("234567").getBalance() == 200);

    }

    @Test
    public void whenTransferToNonExistingAccountBalancesAreNotChanged(){
        // given
        // ..

        // when
        bank.transfer("123456", "XXX567", 500f);

        // then
        Assert.assertTrue(accounts.get("123456").getBalance() == 100);
        Assert.assertTrue(accounts.get("234567").getBalance() == 200);

    }

    public void totalSumReturnsTotalSumOfBalances(){
        // given
        // ..

        // when
        float total = bank.totalSum();

        // then
        Assert.assertTrue(total == 300f);

    }

    public void testReport(){
        bank.report("123456");
    }


}
