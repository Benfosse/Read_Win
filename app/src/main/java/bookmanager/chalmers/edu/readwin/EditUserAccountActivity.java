package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.helpers.UserValidator;
import bookmanager.chalmers.edu.readwin.services.UserService;

public class EditUserAccountActivity extends AppCompatActivity {
    User currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_account);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            currentUser = bundle.getParcelable("user");
        }

        TextView userName = (TextView) findViewById(R.id.account_edit_username);
        TextView firstName = (TextView) findViewById(R.id.account_edit_first_name);
        TextView lastName = (TextView) findViewById(R.id.account_edit_last_name);
        TextView yearOfBirth = (TextView) findViewById(R.id.account_edit_date_of_birth);
        TextView email = (TextView) findViewById(R.id.account_edit_email);

        userName.setText(currentUser.getUserName());
        firstName.setText(currentUser.getFirstName());
        lastName.setText(currentUser.getLastName());
        yearOfBirth.setText(String.valueOf(currentUser.getYearOfBirth()));
        email.setText(currentUser.getEmail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_single_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.save_user)
        {
            EditText firstnameView = (EditText) findViewById(R.id.account_edit_first_name);
            EditText lastnameView = (EditText) findViewById(R.id.account_edit_last_name);
            EditText yearOfBirthView = (EditText) findViewById(R.id.account_edit_date_of_birth);
            EditText emailView = (EditText) findViewById(R.id.account_edit_email);
            EditText passwordView = (EditText) findViewById(R.id.account_edit_password);

            String firstName = firstnameView.getText().toString();;
            String lastName = lastnameView.getText().toString();;
            String email = emailView.getText().toString();;
            String yearOfBirth = yearOfBirthView.getText().toString();;
            String password = passwordView.getText().toString();;

            boolean cancel = false;
            View focusView = null;

            // Check for a valid password, if the user entered one.
            if (TextUtils.isEmpty(password) && !UserValidator.isPasswordValid(password)) {
                passwordView.setError(getString(R.string.error_invalid_password));
                focusView = passwordView;
                cancel = true;
            }

            // Check for a valid email address.
            if (TextUtils.isEmpty(email)) {
                emailView.setError(getString(R.string.error_field_required));
                focusView = emailView;
                cancel = true;
            } else if (!UserValidator.isEmailValid(email)) {
                emailView.setError(getString(R.string.error_invalid_email));
                focusView = emailView;
                cancel = true;
            }

            // Check for a valid firstname, if the user entered one.
            if (TextUtils.isEmpty(firstName)) {
                firstnameView.setError(getString(R.string.error_invalid_firstname));
                focusView = firstnameView;
                cancel = true;
            }

            // Check for a valid lastname, if the user entered one.
            if (TextUtils.isEmpty(lastName)) {
                lastnameView.setError(getString(R.string.error_invalid_lastname));
                focusView = lastnameView;
                cancel = true;
            }

            // Check for a valid Year of Birth, if the user entered one. NEED CHECK YEAR FORM
            if (TextUtils.isEmpty(yearOfBirth)) {
                yearOfBirthView.setError("You forgot your Year of Birth ?");
                focusView = yearOfBirthView;
                cancel = true;}
            else if(!UserValidator.isYearofBirthValid(Integer.parseInt(yearOfBirth))){
                yearOfBirthView.setError(getString(R.string.error_invalid_yearofbirth));
                focusView = yearOfBirthView;
                cancel = true;
            }

            if(cancel) {
                focusView.requestFocus();
            } else {

                User modifiedUser = currentUser;
                modifiedUser.setFirstName(firstName);
                modifiedUser.setLastName(lastName);
                modifiedUser.setYearOfBirth(Integer.parseInt(yearOfBirth));
                modifiedUser.setEmail(email);
                // TODO: Set password

                UserService userService = new UserService();
                userService.modifyCurrentUser(modifiedUser);

                finish();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
