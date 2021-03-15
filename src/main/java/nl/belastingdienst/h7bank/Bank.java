package nl.belastingdienst.h7bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts = new HashMap<String,Account>();

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
}
