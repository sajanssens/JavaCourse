package nl.belastingdienst.h7bank;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.addAccount(new Account("123456", 1000f, 3f));
        bank.addAccount(new Account("234567", 430f, 3.2f));
        bank.addAccount(new Account("345678", 110f, 2.5f));

        bank.report("123456");
        bank.report("234567");
        bank.report("345678");

        System.out.printf("\nTransfer %.2f from 123456 to 345678" , 100f);
        bank.transfer("123456","345678", 100f);

        bank.report("123456");
        bank.report("345678");

        System.out.printf("\n\nTotal amount in the bank: %.2f ", bank.totalSum() );

        bank.showInterests();

    }

}
