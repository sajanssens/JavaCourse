package nl.belastingdienst.h3;

public class Incrementor {

    private void displayInt(int n){
        System.out.println(n);
    }


    public void increment(int n){
        int i = n;
        displayInt(i++); // displays n, ++ is done afterwards
        i = n; // restore entry value
        displayInt(++i); // displays n + 1, ++ is done before
    }
}
