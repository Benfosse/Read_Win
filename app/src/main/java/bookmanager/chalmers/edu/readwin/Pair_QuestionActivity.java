package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import bookmanager.chalmers.edu.readwin.models.Book;

public class Pair_QuestionActivity extends AppCompatActivity {

    FloatingActionButton next, prev;
    int question_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_pair);

        next = (FloatingActionButton) findViewById(R.id.next_Button);
        prev = (FloatingActionButton) findViewById(R.id.prev_Button);

        question_index = getIntent().getIntExtra("index", -1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra("index", question_index+1);
                setResult(RESULT_OK, data);
                finish();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra("index", question_index-1);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }

}
