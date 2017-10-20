package bookmanager.chalmers.edu.readwin.services;

import java.util.ArrayList;
import java.util.List;

import bookmanager.chalmers.edu.readwin.models.Answer;
import bookmanager.chalmers.edu.readwin.models.Multiple_Question;
import bookmanager.chalmers.edu.readwin.models.Pair_Question;
import bookmanager.chalmers.edu.readwin.models.Question;
import bookmanager.chalmers.edu.readwin.services.interfaces.IQuestionService;

/**
 * Created by benedikt on 13/10/2017.
 */

public class QuestionService implements IQuestionService {

    String[] options = new String[]{"Option 1", "Option 2", "Option 3", "Option 4"};
    String[] pair_letter_option = new String[]{"Option A", "Option B", "Option C", "Option D"};

    private Question question1 = new Question(1, "Multiple", new Multiple_Question("What is the name of the main hobbit?", options), null, null);
    private Question question2 = new Question(2, "Multiple", new Multiple_Question("Where are the dwarfes and the hobbit heading?", options), null, null);
    private Question question3 = new Question(3, "Pair", null, new Pair_Question("Is this a question??", options, pair_letter_option), null);


    public List<Question> getBookQuestions(int bookId) {
        List<Question> questions = new ArrayList<>();

        if(bookId == 1) {
            questions.add(question1);
            questions.add(question2);
            questions.add(question3);
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

    public void answerBookQuestions(int bookId, List<Answer> answers) {

    }

}
