package bookmanager.chalmers.edu.readwin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.services.UserService;

public class UserAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        UserService userService = new UserService();
        User currentUser = userService.getCurrentUser();

        TextView userName = (TextView) findViewById(R.id.account_username);
        TextView firstName = (TextView) findViewById(R.id.account_first_name);
        TextView lastName = (TextView) findViewById(R.id.account_last_name);
        TextView yearOfBirth = (TextView) findViewById(R.id.account_date_of_birth);
        TextView email = (TextView) findViewById(R.id.account_email);

        userName.setText(currentUser.getUserName());
        firstName.setText(currentUser.getFirstName());
        lastName.setText(currentUser.getLastName());
        yearOfBirth.setText(String.valueOf(currentUser.getYearOfBirth()));
        email.setText(currentUser.getEmail());
    }



}
