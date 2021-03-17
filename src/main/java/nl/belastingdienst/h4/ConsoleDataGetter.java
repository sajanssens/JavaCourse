package nl.belastingdienst.h4;

import java.util.Scanner;

/**
 * Get data from console
 * Note how prompt is not part of the interface
 * That would be a 'leaky abstraction'.
 */
public class ConsoleDataGetter implements DataGetter{

    private String prompt = "";
    private String input = "";

    public ConsoleDataGetter(String prompt){
        this.prompt = prompt;
    }
    public ConsoleDataGetter(){}

    public String getData(){

        boolean inputOk = false;
        Scanner in = new Scanner(System.in);
        String input = "";

        while(!inputOk) {
            System.out.println(this.prompt);
            input = in.nextLine();
            inputOk = validate(input);
        }

        return input;

    }

    public boolean validate(String input) {
        return true;
    }



}
