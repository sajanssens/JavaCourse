package nl.belastingdienst.h7bank;

public class Account {

    private String bankNr;
    private float balance;
    private float interestRate;

    public boolean withdraw(float amount) {
        float newAmount = getBalance() - amount;
        if (newAmount >= 0) {
            setBalance(newAmount);
            return true;
        }
        return false;

    }

    public void deposit(float amount) {
        this.setBalance(this.getBalance() + amount);
    }

    // https://www.calculatorsoup.com/calculators/financial/simple-interest-plus-principal-calculator.php
    public float calcInterest(int years) {
        float principal = this.balance;
        float rate = (this.interestRate / 100);
        return principal * (1 + (rate * years)); // klopt deze berekening wel?
    }

    // het is gebruikelijk (maar niet verplicht) om de constructors bovenin de class te definieren
    public Account(String bankNr, float balance, float interestRate) {
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
