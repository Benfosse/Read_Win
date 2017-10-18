package bookmanager.chalmers.edu.readwin.models;

/**
 * Created by andreranito on 18/10/2017.
 */

public class Pair_Question {

    private String Heading;
    private String[] Number_Column;
    private String[] Letter_Column;

    public Pair_Question(String heading, String[] number_Column, String[] letter_column) {

        Heading = heading;
        Number_Column = number_Column;
        Letter_Column = letter_column;
    }


    public String getHeading() { return Heading; }

    public String[] getNumber_Column() { return Number_Column; }

    public String[] getLetter_Column() { return Letter_Column; }


}
