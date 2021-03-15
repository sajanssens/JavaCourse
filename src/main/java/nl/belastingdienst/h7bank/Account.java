package nl.belastingdienst.h7bank;

public class Account {

    private String bankNr;
    private float balance;
    private float interestRate;

    public boolean withdraw(float amount ){
       float newAmount = this.getBalance() - amount;
       if(newAmount >= 0){
           this.setBalance(newAmount);
           return true;
       }
       return false;

    }

    public void deposit(float amount){
        this.setBalance(this.getBalance() + amount);
    }

    public float calcInterest(){
        return this.interestRate * (this.getBalance() / 100);
    }

    public Account(String bankNr, float balance, float interestRate){
        this.setBankNr(bankNr);
        // todo check positive
        this.setBalance(balance);
        this.interestRate = interestRate;
    }

    public float getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getBankNr() {
        return bankNr;
    }

    public void setBankNr(String bankNr) {
        this.bankNr = bankNr;
    }
}
