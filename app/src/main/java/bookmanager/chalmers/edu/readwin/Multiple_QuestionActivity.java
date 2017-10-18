package bookmanager.chalmers.edu.readwin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;
import bookmanager.chalmers.edu.readwin.models.Question;
import bookmanager.chalmers.edu.readwin.services.QuestionService;

public class Multiple_QuestionActivity extends AppCompatActivity {

    RadioButton ans1, ans2, ans3, ans4;
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_multiplechoice);

        ans1 = (RadioButton)findViewById(R.id.radioButton1);
        ans2 = (RadioButton)findViewById(R.id.radioButton2);
        ans3 = (RadioButton)findViewById(R.id.radioButton3);
        ans4 = (RadioButton)findViewById(R.id.radioButton4);
        question = (TextView)findViewById(R.id.textQuestion);


        question.setText(getIntent().getStringExtra("Question"));

        String[] options = getIntent().getStringArrayExtra("Options");
        ans1.setText(options[0]);
        ans2.setText(options[1]);
        ans3.setText(options[2]);
        ans4.setText(options[3]);

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(true);
                ans2.setChecked(false);
                ans3.setChecked(false);
                ans4.setChecked(false);
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(false);
                ans2.setChecked(true);
                ans3.setChecked(false);
                ans4.setChecked(false);
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(false);
                ans2.setChecked(false);
                ans3.setChecked(true);
                ans4.setChecked(false);
            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setChecked(false);
                ans2.setChecked(false);
                ans3.setChecked(false);
                ans4.setChecked(true);
            }
        });

    }
}
