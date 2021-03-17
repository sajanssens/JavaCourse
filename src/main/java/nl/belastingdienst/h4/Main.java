package nl.belastingdienst.h4;

public class Main {

    public static void main(String[] args) {

        DataGetter dg = new DataGetter("Your account number: ");
        Account acc = new Account();

        while (acc.getState() != AccountState.ok) {

            acc.setNumber(dg.getData());
            acc.validate();
            System.out.println(acc.getState().getDescription());

        }


    }

}
