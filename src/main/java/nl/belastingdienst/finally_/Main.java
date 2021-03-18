package nl.belastingdienst.finally_;

public class Main {
    public static void main(String[] args){
        Finalizer f = new Finalizer();
        float result;

        System.out.println("Valid division");
        result = f.divide(10f, 2f);

        System.out.println("Invalid division");
        result = f.divide(10f, 2f);

        System.out.println("Valid call");
        int[] x = {1,2,3,4,5};
        f.showFifthElement(x);

        System.out.println("Invalid call");
        int[] y = {1};
        f.showFifthElement(y);

    }
}
