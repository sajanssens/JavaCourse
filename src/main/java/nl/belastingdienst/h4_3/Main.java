package nl.belastingdienst.h4_3;

import nl.belastingdienst.h4.ConsoleDataGetter;

public class Main {
    public static void main(String[] args) {

        boolean inputOk = false;
        int width;

        ConsoleDataGetter dg = new ConsoleWidthGetter("Width of Hour Glass: ");
        while (!inputOk) {
            try {
                width = Integer.parseInt(dg.getData());
                HourGlass hg = new HourGlass(width, 'X');
                hg.draw();
                inputOk = true;
            } catch (TooManyErrorsException e) {
                System.out.println("Too many wrong tries, let's stop");
                System.out.println(e.getMessage());
                // Is this bad?
                System.exit(1);
            } catch (NumberFormatException nfe) {
                System.out.println("Input is not a valid number");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

// https://www.baeldung.com/java-check-string-number
