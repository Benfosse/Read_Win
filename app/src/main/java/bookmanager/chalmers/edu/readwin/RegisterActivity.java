package bookmanager.chalmers.edu.readwin;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import bookmanager.chalmers.edu.readwin.helpers.UserValidator;
import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.services.UserService;

public class RegisterActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mFirstname;
    private EditText mLastname;
    private EditText mYearOfBirth;
    private EditText mEmail;
    private EditText mPassword;
    private View mProgressView;
    private View mLoginFormView;
    private UserRegisterTask mAuthTask = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setBackgroundDrawableResource(R.drawable.background);

        mUsername = (EditText) findViewById(R.id.usernameform);
        mFirstname = (EditText) findViewById(R.id.firstnameform);
        mLastname = (EditText) findViewById(R.id.lastnameform);
        mYearOfBirth = (EditText) findViewById(R.id.dateofbirthform);
        mEmail = (EditText) findViewById(R.id.emailform);
        mPassword = (EditText) findViewById(R.id.passwordform);

        Button mValidate = (Button) findViewById(R.id.validatebutton);
        mValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmail.setError(null);
        mPassword.setError(null);

        // Store values at the time of the register attempt.
        String username = mUsername.getText().toString();
        String firstname = mFirstname.getText().toString();
        String lastname = mLastname.getText().toString();
        int yearofbirth = 0;
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) && !UserValidator.isPasswordValid(password)) {
            mPassword.setError(getString(R.string.error_invalid_password));
            focusView = mPassword;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmail.setError(getString(R.string.error_field_required));
            focusView = mEmail;
            cancel = true;
        } else if (!UserValidator.isEmailValid(email)) {
            mEmail.setError(getString(R.string.error_invalid_email));
            focusView = mEmail;
            cancel = true;
        }

        // Check for a valid username, if the user entered one.
        if (TextUtils.isEmpty(username)) {
            mUsername.setError(getString(R.string.error_invalid_username));
            focusView = mUsername;
            cancel = true;
        }

        // Check for a valid firstname, if the user entered one.
        if (TextUtils.isEmpty(firstname)) {
            mFirstname.setError(getString(R.string.error_invalid_firstname));
            focusView = mFirstname;
            cancel = true;
        }

        // Check for a valid lastname, if the user entered one.
        if (TextUtils.isEmpty(lastname)) {
            mLastname.setError(getString(R.string.error_invalid_lastname));
            focusView = mLoginFormView;
            cancel = true;
        }

        // Check for a valid Year of Birth, if the user entered one. NEED CHECK YEAR FORM
        if (TextUtils.isEmpty(mYearOfBirth.getText())) {
            mYearOfBirth.setError("You forgot your Year of Birth ?");
            focusView = mYearOfBirth;
            cancel = true;}
        else if(!UserValidator.isYearofBirthValid(Integer.parseInt(mYearOfBirth.getText().toString()))){
            mYearOfBirth.setError(getString(R.string.error_invalid_yearofbirth));
            focusView = mYearOfBirth;
            cancel = true;
        }
        else{
            yearofbirth=Integer.parseInt(mYearOfBirth.getText().toString());
        }

        //mAuthTask.execute();

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            UserService userService = new UserService(getApplicationContext());
            userService.createUser(username, email, firstname, lastname, yearofbirth, null, password);
            Intent gameMainPage = new Intent(this, GameMainPage.class);
            startActivity(gameMainPage);
        }
    }

    public class UserRegisterTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;
        private final String mUsername;
        private final String mFirstname;
        private final String mLastname;
        private final int mYearofbirth;



        UserRegisterTask(String email, String password, String username, String firstname, String lastname, int yearofbirth) {
            mEmail = email;
            mPassword = password;
            mUsername = username;
            mFirstname = firstname;
            mLastname = lastname;
            mYearofbirth = yearofbirth;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }


    }
}

