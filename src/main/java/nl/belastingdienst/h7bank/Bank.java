package nl.belastingdienst.h7bank;

import java.util.HashMap;
import java.util.Map;

// http://www.sergiy.ca/how-to-iterate-over-a-map-in-java

public class Bank {

    private Map<String, Account> accounts = new HashMap<String,Account>();
    // why not Map<> x = new Map<>() ??? (instead of HashMap)

    public void addAccount(Account account){
        this.accounts.put(account.getBankNr(), account);
    }

    public boolean transfer(String fromBankNr, String toBankNr, float amount){
        Account accountFrom = accounts.get(fromBankNr);
        boolean succeeded = false;
        if(!accountFrom.equals(null)){
            // source account exists
            Account accountTo = accounts.get(toBankNr);
            if(!accountTo.equals(null)) {
                // target account exists
                if(accountFrom.withdraw(amount)){
                    // enough balance!
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

    public void report(String bankNr){
        Account account = accounts.get(bankNr);
        if(!account.equals(null)){
            System.out.println("\n---------------");
            System.out.printf("\nBankNr: %s",account.getBankNr());
            System.out.printf("\nBalance: %s",account.getBalance());
            System.out.printf("\nInterestRate: %s",account.getInterestRate());
            System.out.printf("\nInterest Amount: %s",account.calcInterest());
        }
    }

    public float totalSum(){

        float totalSum = 0;

        for (Map.Entry<String, Account> account : this.accounts.entrySet()) {
            // System.out.println("Key = " + account.getKey() + ", Amount = " + account.getValue().getBalance());

            totalSum += account.getValue().getBalance();
        }
        return totalSum;
    }

    public void showInterests(){

        System.out.println("\n-------------------");
        for (Map.Entry<String, Account> account : this.accounts.entrySet()) {

            System.out.printf("\nAccount %s, rate %.2f, amount %.2f", account.getKey(), account.getValue().getInterestRate(), account.getValue().calcInterest() );

        }
    }

}
