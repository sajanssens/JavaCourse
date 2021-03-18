package nl.belastingdienst.finally_;

public class Finalizer {
    public float divide(float dividend, float divisor){
        try{
            return dividend / divisor;
        }
        finally{
            System.out.println("***** finally clause! *****");
        }
    }

    public void showFifthElement(int[] stuff){
        try{
            System.out.println(stuff[4]);
        }
        catch(Exception e){
            System.out.println("Oops! " + e.getMessage());
        }
        finally{
            // It is DRYer to implement this in the finally
            System.out.println("**** Process done *****");
        }
    }
}


