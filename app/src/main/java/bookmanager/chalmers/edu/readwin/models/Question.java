package bookmanager.chalmers.edu.readwin.models;

/**
 * Created by benedikt on 12/10/2017.
 */

public class Question {
    private int QuestionNumber;
    private String Type;

    private Multiple_Question Multiple;
    private Pair_Question Pair;
    private Ordering_Question Ordering;


    public Question(int questionNumber, String type, Multiple_Question multiple, Pair_Question pair, Ordering_Question ordering) {
        QuestionNumber = questionNumber;
        Type = type;
        Multiple = multiple;
        Pair = pair;
        Ordering = ordering;
    }

    public int getQuestionNumber() {
        return QuestionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        QuestionNumber = questionNumber;
    }

    public String getType() { return Type; }

    public void setType(String type) { this.Type = type; }

    public Multiple_Question getMultiple() { return Multiple; }

    public Pair_Question getPair() { return Pair; }

    public Ordering_Question getOrdering() { return Ordering; }


}
