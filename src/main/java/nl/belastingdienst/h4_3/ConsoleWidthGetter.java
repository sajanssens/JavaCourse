package nl.belastingdienst.h4_3;

import nl.belastingdienst.h4.ConsoleDataGetter;

public class ConsoleWidthGetter extends ConsoleDataGetter {

    private int errorCount = 0;

    /**
     * Throw given exception but if this is the third time throw a TooManyErrorsException
     * @throws TooManyErrorsException
     *
     * @param e the exception
     */
    private void throwOrEscape(RuntimeException e) {
        this.errorCount++;
        if (errorCount >= 3) {
            throw (new TooManyErrorsException("Three times wrong!"));
        } else {
            throw (e);
        }
    }

    @Override
    public boolean validate(String input) {

        int nr = 0;

        // is it an integer?
        try {
            nr = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            this.throwOrEscape(e);
        }

        // is it odd?
        if ((nr % 2) == 0) {
            // even not allowed
            throwOrEscape(new EvenNumberException("Only odd numbers allowed"));
        }

        // is it larger then 4?
        if(nr<5){
            throwOrEscape(new NumberTooSmallException("Try 5 (or more)"));
        }

        return true;
    }

    public ConsoleWidthGetter(String prompt) {
        super(prompt);
    }

}
