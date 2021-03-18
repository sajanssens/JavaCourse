package nl.belastingdienst.h7bank;

import java.util.HashMap;
import java.util.Map;

// http://www.sergiy.ca/how-to-iterate-over-a-map-in-java

public class Bank {

    //       type of key, type of content
    private Map<String, Account> accounts = new HashMap<String, Account>();
    // HashMap is child of Map!!

    // Add an account to the bank
    // todo check on existence
    public void addAccount(Account account) {
        this.accounts.put(account.getBankNr(), account);
    }

    /**
     * Transfer amount
     *
     * @param fromBankNr account from
     * @param toBankNr   account to
     * @param amount     amount to transfer
     * @return true if succeeded. If false one or both of the accounts do not exist or insuffucient balance on source account
     * @todo raise exception rather then print a message
     */
    public boolean transfer(String fromBankNr, String toBankNr, float amount) {
        // ik heb het gevoel dat deze methode wel korter kan.

        // do not allow negative amounts
        if (amount < 0) {
            System.out.println("Negative amount not allowed");
            return false;
        }

        // source account exists?
        Account accountFrom = accounts.get(fromBankNr);
        if (accountFrom == null) {
            System.out.printf("\naccount %s does not exist", fromBankNr);
            return false;
        }
        // target account exists?
        Account accountTo = accounts.get(toBankNr);
        if (accountTo == null) {
            System.out.printf("\naccount %s does not exist", toBankNr);
            return false;
        }

        // enough balance on source?
        if (!accountFrom.withdraw(amount)) {
            System.out.printf("\naccount %s does not have enough balance", fromBankNr);
            return false;
        }

        accountTo.deposit(amount);

        return true;

    }

    // Show data of given account
    public void report(String bankNr) {
        Account account = accounts.get(bankNr);
        if (!account.equals(null)) { // hier bedoel je denk ik account != null i.p.v. equals
            // dit kun je ook in een toString van Account zetten
            System.out.println("\n---------------");
            System.out.printf("\nBankNr: %s", account.getBankNr());
            System.out.printf("\nBalance: %s", account.getBalance());
            System.out.printf("\nInterestRate: %s", account.getInterestRate());

        } else {
            System.out.printf("\nAccount %s does not exist", bankNr);
        }
    }

    /**
     * Calculate total amount of money in the bank
     *
     * @return the total amount
     */
    public float totalSum() {

        float totalSum = 0;

        //      descr. of single element        :  collection of type Iterable
        //                                            Iterable is an interface you can implement
        //                                            on your own classes.
        for (var accountEntry : this.accounts.entrySet()) {
            // System.out.println("Key = " + account.getKey() + ", Amount = " + account.getValue().getBalance());

            // NOTE: account is not yet the Account but a HashMapNode (?)
            // use getKey to get key, getValue for value. value IS of type Account
            totalSum += accountEntry.getValue().getBalance();
        }

        return totalSum;
    }

    /**
     * Show list of accounts with interest amount
     */
    public void showInterests(int years) {

        System.out.println("\n-------------------");
        // although keyword is 'for', this is called 'foreach'
        for (var accountEntry : this.accounts.entrySet()) {
            System.out.printf("\nAccount %s, rate %.2f, amount %.2f", accountEntry.getKey(), accountEntry.getValue().getInterestRate(), accountEntry.getValue().calcInterest(years));
        }
    }

    public Map<String, Account> getAccounts() {
        return this.accounts;
    }

}
