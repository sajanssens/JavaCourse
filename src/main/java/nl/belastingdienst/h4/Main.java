package nl.belastingdienst.h4;

public class Main {

    public static void main(String[] args) {

        DataGetter dg = new DataGetter("Rekeningnummer: ");
        Account acc = new Account();

        while (acc.getState() != 0) {

            acc.setNumber(dg.getData());
            acc.validate();
            System.out.println(acc.getStateText());

        }


    }

}
