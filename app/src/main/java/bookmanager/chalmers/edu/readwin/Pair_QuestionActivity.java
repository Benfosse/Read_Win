package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.content.res.ColorStateList;
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
    int question_index, n_of_questions;
    TextView Option1, Option2, Option3, Option4, OptionA, OptionB, OptionC, OptionD, Heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_pair);

        Heading = (TextView)findViewById(R.id.heading);

        Option1 = (TextView)findViewById(R.id.option1);
        Option2 = (TextView)findViewById(R.id.option2);
        Option3 = (TextView)findViewById(R.id.option3);
        Option4 = (TextView)findViewById(R.id.option4);
        OptionA = (TextView)findViewById(R.id.optionA);
        OptionB = (TextView)findViewById(R.id.optionB);
        OptionC = (TextView)findViewById(R.id.optionC);
        OptionD = (TextView)findViewById(R.id.optionD);

        Heading.setText(getIntent().getStringExtra("Heading"));


        n_of_questions = getIntent().getIntExtra("N_of_Quesions", 0);
        question_index = getIntent().getIntExtra("index", -1);

        Disable(OptionA);
        Disable(OptionB);
        Disable(OptionC);
        Disable(OptionD);


        Option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.BOLD);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);
                Enable(OptionA);
                Enable(OptionB);
                Enable(OptionC);
                Enable(OptionD);
            }
        });
        Option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.BOLD);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);
            }
        });
        Option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.BOLD);
                Option4.setTypeface(null, Typeface.NORMAL);
            }
        });
        Option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.BOLD);
            }
        });

        OptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);

                

            }
        });

        OptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);
            }
        });

        OptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);
            }
        });

        OptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option1.setTypeface(null, Typeface.NORMAL);
                Option2.setTypeface(null, Typeface.NORMAL);
                Option3.setTypeface(null, Typeface.NORMAL);
                Option4.setTypeface(null, Typeface.NORMAL);
            }
        });


        next = (FloatingActionButton) findViewById(R.id.next_Button);
        prev = (FloatingActionButton) findViewById(R.id.prev_Button);

        question_index = getIntent().getIntExtra("index", -1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question_index < n_of_questions) {
                    Intent data = new Intent();
                    data.putExtra("index", question_index + 1);
                    setResult(RESULT_OK, data);
                    finish();
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question_index > 0) {
                    Intent data = new Intent();
                    data.putExtra("index", question_index - 1);
                    setResult(RESULT_OK, data);
                    finish();
                }
            }
        });
    }

    private void Enable(TextView text) {
        text.setTextColor(Color.parseColor("#000000"));
        text.setEnabled(true);
    }

    private void Disable(TextView text) {
        text.setTextColor(Color.parseColor("#9d9c9e"));
       text.setEnabled(false);
    }

}
