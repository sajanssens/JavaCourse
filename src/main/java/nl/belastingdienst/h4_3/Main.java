package nl.belastingdienst.h4_3;

import nl.belastingdienst.h4.ConsoleDataGetter;

public class Main {
    public static void main(String[] args) {

        boolean inputOk = false;
        int width;

        ConsoleDataGetter dg = new ConsoleDataGetter("Width of Hour Glass: ");
        while (!inputOk) {
            try {
                width = Integer.parseInt(dg.getData());
                HourGlass hg = new HourGlass(width, 'X');
                hg.draw();
                inputOk = true;
            } catch (EvenNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
