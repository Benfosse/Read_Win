package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.services.UserService;

public class UserAccountActivity extends AppCompatActivity {

    User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        UserService userService = new UserService(getApplicationContext());
        currentUser = userService.getCurrentUser();

        TextView userName = (TextView) findViewById(R.id.account_username);
        TextView firstName = (TextView) findViewById(R.id.account_first_name);
        TextView lastName = (TextView) findViewById(R.id.account_last_name);
        TextView yearOfBirth = (TextView) findViewById(R.id.account_date_of_birth);
        TextView email = (TextView) findViewById(R.id.account_email);
        TextView userScore = (TextView) findViewById(R.id.account_score);

        userName.setText(currentUser.getUserName());
        firstName.setText(currentUser.getFirstName());
        lastName.setText(currentUser.getLastName());
        yearOfBirth.setText(String.valueOf(currentUser.getYearOfBirth()));
        email.setText(currentUser.getEmail());
        userScore.setText(String.valueOf(currentUser.getCurrentScore()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_user, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        UserService userService = new UserService(getApplicationContext());
        currentUser = userService.getCurrentUser();

        TextView userName = (TextView) findViewById(R.id.account_username);
        TextView firstName = (TextView) findViewById(R.id.account_first_name);
        TextView lastName = (TextView) findViewById(R.id.account_last_name);
        TextView yearOfBirth = (TextView) findViewById(R.id.account_date_of_birth);
        TextView email = (TextView) findViewById(R.id.account_email);
        TextView userScore = (TextView) findViewById(R.id.account_score);

        userName.setText(currentUser.getUserName());
        firstName.setText(currentUser.getFirstName());
        lastName.setText(currentUser.getLastName());
        yearOfBirth.setText(String.valueOf(currentUser.getYearOfBirth()));
        email.setText(currentUser.getEmail());
        userScore.setText(String.valueOf(currentUser.getCurrentScore()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.edit_user)
        {
            Intent editUserAccountIntent = new Intent(UserAccountActivity.this,
                    EditUserAccountActivity.class);

            Bundle bundle = new Bundle();
            bundle.putParcelable("user", currentUser);
            editUserAccountIntent.putExtras(bundle);

            startActivity(editUserAccountIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
