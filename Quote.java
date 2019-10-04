
/*
* TCSS 305 – Winter 2018
* Assignment 0 – Orientation
*/

/**
 * This program displays my personal information.
 * 
 * @author Abdulfetah Siraj.
 * @version January 09, 2018.
 */

public final class Quote {
    /**
     * Declared a string variable for myFullName.
     */
    private String myFullName;
    /**
     * Declared a string variable for myQuote.
     */
    private String myQuote;

    /**
     * This gets my name from MainClass and return.
     * 
     * @return my FullName.
     */
    public String getFullName() {
        return myFullName;
    }

    /**
     * This sets My name through parameter. 
     * @param theFullName it pass as my full name as a parameter.
     */
    public void setFullName(final String theFullName) {
        this.myFullName = theFullName;
    }

    /**
     * This gets the data from MainClass and return.
     * 
     * @return It returns My Quote
     */

    public String getQuote() {
        return myQuote;
    }

    /**
     * This sets the Quote through parameter. passed String value from MainClass.S
     * 
     * @param theQuote it pass the string value as a parameter.
     */
    public void setQoute(final String theQuote) {
        this.myQuote = theQuote;
    }
}
