package nl.belastingdienst.h4;

import java.util.Scanner;

public class DataGetter {

    private String prompt = "";

    public DataGetter(String prompt){
        this.prompt = prompt;
    }

    public String getData(){

        Scanner in = new Scanner(System.in);
        System.out.println(this.prompt);
        return in.nextLine();

    }

}
