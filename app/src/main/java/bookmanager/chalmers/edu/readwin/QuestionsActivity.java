package bookmanager.chalmers.edu.readwin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import bookmanager.chalmers.edu.readwin.models.Multiple;
import bookmanager.chalmers.edu.readwin.models.Question;
import bookmanager.chalmers.edu.readwin.services.QuestionService;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);



    }
}
