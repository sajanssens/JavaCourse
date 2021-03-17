package nl.belastingdienst.h4_2;


import nl.belastingdienst.h4.ConsoleDataGetter;

public class Main {
    // https://www.baeldung.com/java-string-to-enum
    public static void main(String[] args) {

        String temperature;
        ConsoleDataGetter dg = new ConsoleDataGetter("Season: ");

        String input = dg.getData();

        Season s = Season.valueOf(input);

        switch(s){
            case Winter :
            case Autumn:
                temperature = "Cold";
                break;
            case Spring:
            case Summer:
                temperature = "Warm";
                break;
            default:
                temperature = "Unknown";
        }

        System.out.println("Temperature in this season is "+temperature);

    }

}
