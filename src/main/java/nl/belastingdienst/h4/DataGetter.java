package nl.belastingdienst.h4;

/*
 A very simple interface
 Just to try interfaces in java
 */
public interface DataGetter {
    /**
     * get data from source
     *
     * @return the data
     */
    public String getData();
    public boolean validate(String input);
}
