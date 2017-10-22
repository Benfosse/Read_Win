package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.models.Pair_Question;

public class Pair_QuestionActivity extends AppCompatActivity {

    FloatingActionButton next, prev;
    int question_index;
    TextView Option1, Option2, Option3, Option4, OptionA, OptionB, OptionC, OptionD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_pair);

        Option1 = (TextView)findViewById(R.id.option1);


        Option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.BOLD);
            }
        });

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
