package nl.belastingdienst.h4_2;

import nl.belastingdienst.h4.ConsoleDataGetter;

public class Main {
    // https://www.baeldung.com/java-string-to-enum
    public static void main(String[] args) {

        String temperature;
        ConsoleDataGetter dg = new ConsoleDataGetter("Season: ");

        String input = dg.getData();

        // Season is a string now, but we need a enum, this is the (a?) way
        Season s = Season.valueOf(input);

        switch(s){
            case Winter : // intentionally left out 'break', in effect it becomes an 'OR'
            case Autumn:
                temperature = "Cold";
                break;
            case Spring: // intentionally left out 'break', in effect it becomes an 'OR'
            case Summer:
                temperature = "Warm";
                break;
            default:
                temperature = "Unknown";
        }

        System.out.println("Temperature in this season is "+temperature);

    }

}
