package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import bookmanager.chalmers.edu.readwin.models.Multiple_Question;
import bookmanager.chalmers.edu.readwin.models.Question;
import bookmanager.chalmers.edu.readwin.services.QuestionService;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);


        List<Question> questions = new QuestionService().getBookQuestions(1);
        int question_index=0;

        switch (questions.get(question_index).getType()) {

            case "Multiple":
                Intent multiple = new Intent(QuestionsActivity.this, Multiple_QuestionActivity.class);
                multiple.putExtra("index", questions.get(question_index).getQuestionNumber());
                multiple.putExtra("Question", questions.get(question_index).getMultiple().getQuestion());
                multiple.putExtra("Options", questions.get(question_index).getMultiple().getOptions());
                startActivity(multiple);

            case "Pair":

            case "Ordering":

            case "default":

        }

    }
}
