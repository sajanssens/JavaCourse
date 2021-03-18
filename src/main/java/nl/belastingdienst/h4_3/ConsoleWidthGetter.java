package nl.belastingdienst.h4_3;

import nl.belastingdienst.h4.ConsoleDataGetter;

/**
 * Class to retrieve value for width from the console
 */
public class ConsoleWidthGetter extends ConsoleDataGetter {

    private int errorCount = 0;
    private final int MAXERRORS = 3;

    /**
     * Throw given exception but if this is the nth time throw a TooManyErrorsException
     * @throws TooManyErrorsException
     * @todo TooManyErrorsException should contain original expression as well
     *
     * @param e the exception
     */
    private void throwOrEscape(RuntimeException e) {
        this.errorCount++;
        if (errorCount >= MAXERRORS) {
            // too many errors, raise exception accordingly
            throw (new TooManyErrorsException("Three times wrong!"));
        } else {
            // raise the passed exception
            throw (e);
        }
    }

    @Override
    /**
     * Input should be an odd integer
     * @return true if ok, never false.. in case of error an exception is thrown
     */
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
