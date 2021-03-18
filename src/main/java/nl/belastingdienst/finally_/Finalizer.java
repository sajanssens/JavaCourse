package nl.belastingdienst.finally_;

public class Finalizer {
    public float divide(float dividend, float divisor) {
        try {
            return dividend / divisor;
        } finally {
            System.out.println("***** finally clause! *****");
        }
    }

    public void showFifthElement(int[] stuff) {
        try {
            System.out.println(stuff[4]);
        } catch (Exception e) {
            System.out.println("Oops! " + e.getMessage());
        } finally {
            // It is DRYer to implement this in the finally
            System.out.println("**** Process done *****");
        }
    }

    public void showFifthElement2(int[] stuff) {
        // this achieves same as showFifthElement
        // so no finally needed then?
        try {
            System.out.println(stuff[4]);
        } catch (Exception e) {
            System.out.println("Oops! " + e.getMessage());

        }
        System.out.println("**** Process done *****");

    }

    public void showFifthElement3(int[] stuff) {
        // we do need finally if we have no catch or catch throws exception itself (even implicitly)
        // so this example doesn't print the done line in case of error
        try {
            System.out.println(stuff[4]);
        } catch (Exception e) {
            System.out.println("Oops! " + e.getMessage());
            throw(e);
        }
        System.out.println("**** Process done *****");

    }

    public void showFifthElement4(int[] stuff) {
        // so this example does print the done line in case of error!
        try {
            System.out.println(stuff[4]);
        } catch (Exception e) {
            System.out.println("Oops! " + e.getMessage());
            throw(e);
        }
        System.out.println("**** Process done *****");
    }

}


