package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import bookmanager.chalmers.edu.readwin.models.Question;
import bookmanager.chalmers.edu.readwin.services.QuestionService;


public class QuestionsActivity extends AppCompatActivity {

    static final int RESULT_MULTIPLE = 0, RESULT_PAIR = 1, RESULT_ORDERING = 2;
    int question_index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        List<Question> questions = new QuestionService().getBookQuestions(1);

        switch (questions.get(question_index).getType()) {

            case "Multiple":
                Intent multiple = new Intent(QuestionsActivity.this, Multiple_QuestionActivity.class);
                multiple.putExtra("index", question_index);
                multiple.putExtra("question_number", questions.get(question_index).getQuestionNumber());
                multiple.putExtra("Question", questions.get(question_index).getMultiple().getQuestion());
                multiple.putExtra("Options", questions.get(question_index).getMultiple().getOptions());
                startActivityForResult(multiple, RESULT_MULTIPLE);

            case "Pair":

            case "Ordering":

            case "default":

        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_questions);

        List<Question> questions = new QuestionService().getBookQuestions(1);

        switch (questions.get(question_index).getType()) {

            case "Multiple":
                Intent multiple = new Intent(QuestionsActivity.this, Multiple_QuestionActivity.class);
                multiple.putExtra("index", question_index);
                multiple.putExtra("question_number", questions.get(question_index).getQuestionNumber());
                multiple.putExtra("Question", questions.get(question_index).getMultiple().getQuestion());
                multiple.putExtra("Options", questions.get(question_index).getMultiple().getOptions());
                startActivityForResult(multiple, RESULT_MULTIPLE);

            case "Pair":

            case "Ordering":

            case "default":

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == RESULT_MULTIPLE) {
            if (data != null) {
                int temp = data.getIntExtra("index", -1);
                question_index = temp;
            }
        }
    }
}
