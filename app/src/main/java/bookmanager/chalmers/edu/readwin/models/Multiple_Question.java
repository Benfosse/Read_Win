package bookmanager.chalmers.edu.readwin.models;

/**
 * Created by andreranito on 18/10/2017.
 */

public class Multiple_Question {

    private String[] Options;
    private String Question;

    public Multiple_Question(String question, String[] options) {
        Question = question;
        Options = options;
    }

    public String[] getOptions() { return Options; }

    public String getQuestion() { return Question; }

}
