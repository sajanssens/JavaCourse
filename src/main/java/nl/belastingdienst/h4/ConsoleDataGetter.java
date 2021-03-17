package nl.belastingdienst.h4;

import java.util.Scanner;

/**
 * Get data from console
 * Note how prompt is not part of the interface
 * That would be a 'leaky abstraction'.
 */
public class ConsoleDataGetter implements DataGetter{

    private String prompt = "";

    public ConsoleDataGetter(String prompt){
        this.prompt = prompt;
    }

    public String getData(){

        Scanner in = new Scanner(System.in);
        System.out.println(this.prompt);
        return in.nextLine();

    }

}
