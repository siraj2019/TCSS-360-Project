
/*
 * TCSS 305 – Winter 2018. 
 * Assignment 0 – Orientation.
 */
/**
 * 
 * @author Abdulfetah Siraj
 * @version Winter 09, 2018
 *
 */

public final class MainClass {

    /**
     * Create a Main Class.
     */

    private MainClass() {

    }

    /**
     * This program displays my favorite Quote from the movie BREAKING BAD.
     * 
     * @param theArgs
     *            ** this is a string parameter for the main method**.
     * 
     */
    public static void main(final String[] theArgs) {

        final Quote aas = new Quote(); // aas is an instantiate object.
        aas.setFullName("Abdulfetah Siraj");
        aas.setQoute("Quotes from the Movie." + '\n' + "BREAKING BAD" + '\n'
                + "Walter: **I have spent my whole life scared, " + '\n'
                + "frightened of things that could happen, might" + '\n'
                + "happen, might not happen," + '\n' + "50-years I spent like that**");

        System.out.print("FullName: " + aas.getFullName() + "'\n' Hobby: " + aas.getQuote());

    }

}
