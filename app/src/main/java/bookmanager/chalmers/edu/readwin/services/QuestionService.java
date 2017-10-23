package bookmanager.chalmers.edu.readwin.services;

import java.util.ArrayList;
import java.util.List;

import bookmanager.chalmers.edu.readwin.models.Answer;
import bookmanager.chalmers.edu.readwin.models.MultipleQuestion;
import bookmanager.chalmers.edu.readwin.models.PairQuestion;
import bookmanager.chalmers.edu.readwin.models.Question;
import bookmanager.chalmers.edu.readwin.services.interfaces.IQuestionService;

/**
 * Created by benedikt on 13/10/2017.
 */

public class QuestionService implements IQuestionService {

    private Question question1 = new Question(1, "Multiple", new MultipleQuestion("What is the name of the main character in “The Hobbit”?", new String[]{"Frodo", "Bilbo", "Thorin", "Saruman"}), null, null);
    private Question question2 = new Question(2, "Multiple", new MultipleQuestion("What is the name of Bilbo´s home?", new String[]{"Hobbit house", "Bag End", "Bilbo´s Villa", "Frodo creek"}), null, null);
    private Question question3 = new Question(3, "Multiple", new MultipleQuestion("What is Gollum´s name for the ring?", new String[]{"Cutiepie", "Darling", "Precious", "Sugar"}), null, null);
    private Question question4 = new Question(4, "Multiple", new MultipleQuestion("What is the name of the dragon?", new String[]{"Smoke", "Smaug", "Smeer", "Smiley"}), null, null);
    private Question question5 = new Question(5, "Multiple", new MultipleQuestion("Who kills the dragon Smaug?", new String[]{"Gandalf", "Thorin", "Bilbo", "Bard"}), null, null);
    private Question question6 = new Question(6, "Multiple", new MultipleQuestion("What does the magic ring do?", new String[]{"Turns everything into gold", "Turns water into wine", "It makes its wearer invisible", "It gives its wearer superstrength"}), null, null);
    private Question question7 = new Question(7, "Multiple", new MultipleQuestion("What evil charecter lives in Mirkwood?", new String[]{"The Necromancer", "The Alchemist", "The Magician", "The Sorcerer"}), null, null);
    private Question question8 = new Question(8, "Multiple", new MultipleQuestion("What is the name of Bilbo´s sword?", new String[]{"Punisher", "Lightening", "Straw", "Sting"}), null, null);
    private Question question9 = new Question(9, "Multiple", new MultipleQuestion("Where does the dragon Smaug live?", new String[]{"The Misty Mountains", "In the mines of Moria", "In Bag end", "The Lonely Mountain"}), null, null);
    private Question question10 = new Question(10, "Pair", null, new PairQuestion("Pair these together", new String[]{"Bilbo", "Gandalf", "Thorin Oakenshield", "Bard"}, new String[]{"Man", "Wizard", "Hobbit", "Dwarf"}), null);

    public List<Question> getBookQuestions(int bookId) {
        List<Question> questions = new ArrayList<>();

        if(bookId == 1) {
            questions.add(question1);
            questions.add(question2);
            questions.add(question3);
            questions.add(question4);
            questions.add(question5);
            questions.add(question6);
            questions.add(question7);
            questions.add(question8);
            questions.add(question9);
            questions.add(question10);
        }
        return questions;
    }

    public Question getBookQuestion(int bookId, int questionNumber) {
        if(bookId == 1 && questionNumber == 1)
            return question1;
        else if(bookId == 1 && questionNumber == 2)
            return question2;
        else
            return null;
    }

    public int answerBookQuestions(int bookId, List<Answer> answers) {

        if(bookId == 1) {



            return 100;
        }
        else {
            return 0;
        }
    }

}
