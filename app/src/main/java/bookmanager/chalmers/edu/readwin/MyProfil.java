package bookmanager.chalmers.edu.readwin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import bookmanager.chalmers.edu.readwin.models.User;

public class MyProfil extends AppCompatActivity {

    TextView userName;
    TextView firstName;
    TextView lastName;
    TextView email;
    TextView myscore;
    ImageView avatar;
    View mProgressView;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profil);
        getWindow().setBackgroundDrawableResource(R.drawable.general_background);
        Bundle b = getIntent().getExtras();
        User user1 = (User)b.get("user");
        userName = (TextView) findViewById(R.id.usernameform2);
        userName.setText(user1.getUserName());
        firstName = (TextView) findViewById(R.id.firstnameform2);
        firstName.setText(user1.getFirstName());
        lastName = (TextView) findViewById(R.id.lastnameform2);
        lastName.setText(user1.getLastName());
        email = (TextView) findViewById(R.id.emailform2);
        email.setText(user1.getEmail());
        myscore = (TextView) findViewById(R.id.myScoreform2);
        myscore.setText(Integer.toString(user1.getCurrentScore()));

        avatar = (ImageView) findViewById(R.id.avatarPreview);


        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent splash = new Intent(context, Splash.class);
                startActivity(splash);
            }
        });

    }
}
