package nl.belastingdienst.h7bank;

import java.util.HashMap;
import java.util.Map;

// http://www.sergiy.ca/how-to-iterate-over-a-map-in-java

public class Bank {

    //       type of key, type of content
    private Map<String, Account> accounts = new HashMap<String,Account>();
    // HashMap is child of Map!!

    // Add an account to the bank
    // todo check on existence
    public void addAccount(Account account){
        this.accounts.put(account.getBankNr(), account);
    }

    /**
     * Transfer amount
     * @todo  raise exception rather then print a message
     * @param fromBankNr account from
     * @param toBankNr account to
     * @param amount amount to transfer
     * @return true if succeeded. If false one or both of the accounts do not exist or insuffucient balance on source account
     */
    public boolean transfer(String fromBankNr, String toBankNr, float amount){

        Account accountFrom = accounts.get(fromBankNr);

        // assume the worst
        boolean succeeded = false;

        if(!accountFrom.equals(null)){
            // source account exists
            Account accountTo = accounts.get(toBankNr);
            if(!accountTo.equals(null)) {
                // target account exists
                if(accountFrom.withdraw(amount)){
                    // enough balance! Let's move the money
                    accountTo.deposit(amount);
                }
                else{
                    System.out.printf("\naccount %s does not have enough balance", fromBankNr);
                }
            }
            else{
                System.out.printf("\naccount %s does not exist", toBankNr);
            }
        }
        else{
            System.out.printf("\naccount %s does not exist", fromBankNr);
        }

        return succeeded;

    }

    // Show data of given account
    public void report(String bankNr){
        Account account = accounts.get(bankNr);
        if(!account.equals(null)){
            System.out.println("\n---------------");
            System.out.printf("\nBankNr: %s",account.getBankNr());
            System.out.printf("\nBalance: %s",account.getBalance());
            System.out.printf("\nInterestRate: %s",account.getInterestRate());
            System.out.printf("\nInterest Amount: %s",account.calcInterest());
        }
        else{
            System.out.printf("\nAccount %s does not exist", bankNr);
        }
    }

    /**
     * Calculate total amount of money in the bank
     *
     * @return the total amount
     */
    public float totalSum(){

        float totalSum = 0;

        //      descr. of single element        :  collection of type Iterable
        //                                            Iterable is an interface you can implement
        //                                            on your own classes.
        for (Map.Entry<String, Account> account : this.accounts.entrySet()) {
             // System.out.println("Key = " + account.getKey() + ", Amount = " + account.getValue().getBalance());

            // NOTE: account is not yet the Account but a HashMapNode (?)
            // use getKey to get key, getValue for value. value IS of type Account
             totalSum += account.getValue().getBalance();
        }

        return totalSum;
    }

    /**
     * Show list of accounts with interest amount
     */
    public void showInterests(){

        System.out.println("\n-------------------");
        // although keyword is 'for', this is called 'foreach'
        for (Map.Entry<String, Account> account : this.accounts.entrySet()) {
            System.out.printf("\nAccount %s, rate %.2f, amount %.2f", account.getKey(), account.getValue().getInterestRate(), account.getValue().calcInterest() );
        }
    }

}
