package nl.belastingdienst.h4_3;

public class HourGlass {
    private int width;
    private String drawChar;

    public HourGlass(int width){
        this(width, "*");
    }

    public HourGlass(int width, String drawChar){
        this.drawChar = drawChar;
        this.width = width;
    }

    public void draw(){

        int currentLength = this.width;
        int increment = -2; // increase length with this number per row
        String prefix;

        while(increment <= 2) {
            while ((increment == -2 && currentLength > 1) || (increment == 2 && currentLength < this.width)) {
                prefix = " ".repeat((this.width - currentLength) / 2);
                System.out.println(prefix + this.drawChar.repeat(currentLength));
                currentLength += increment;
            }
            increment = Math.abs(increment);
        }

    }


}
