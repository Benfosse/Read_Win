package bookmanager.chalmers.edu.readwin.models;

/**
 * Created by andreranito on 18/10/2017.
 */

public class Ordering_Question {

    private String Question;
    private String[] Events;


    public Ordering_Question(String question, String[] events) {

        Question = question;
        Events = events;
    }

    public String getQuestion() { return Question; }

    public String[] getEvents() { return Events; }

}
