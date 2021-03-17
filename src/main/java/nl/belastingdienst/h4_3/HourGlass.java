package nl.belastingdienst.h4_3;

/*
 Things tried:
 - Constructor override
 - Calling constructor from constructor
 - Converting char to string
 To do:
 -
 */
public class HourGlass {
    private int width;
    private char drawChar;

    public HourGlass(int width) throws EvenNumberException {
        this(width, '*');
    }

    public HourGlass(int width, char drawChar) {
        // checkOdd(width);
        this.drawChar = drawChar;
        this.width = width;
    }

    public void draw() {

        int currentLength = this.width;
        int increment = -2; // increase length with this number per row
        String prefix; // spaces in front of row
        String drawChar = Character.toString(this.drawChar); // convert to string to use repeat method

        for (int i = 0; i < 2; i++) {
            while ((increment == -2 && currentLength > 1) || (increment == 2 && currentLength <= this.width)) {
                prefix = " ".repeat((this.width - currentLength) / 2);
                System.out.println(prefix + drawChar.repeat(currentLength));
                currentLength += increment;
            }
            increment = Math.abs(increment);
        }
    }
}
