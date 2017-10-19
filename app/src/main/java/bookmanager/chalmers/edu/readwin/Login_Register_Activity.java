package bookmanager.chalmers.edu.readwin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import bookmanager.chalmers.edu.readwin.models.Book;
import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.services.UserService;

public class Login_Register_Activity extends AppCompatActivity {

    Button login, register;
    Context context= this;
    UserService userService = new UserService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register_);

        login= (Button)findViewById(R.id.login_button);
        register= (Button)findViewById(R.id.register_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = getIntent().getExtras();
                Intent login= new Intent(context, LoginActivity.class);
                if(b!=null){
                    ArrayList<User> arr = (ArrayList<User>)b.get("userlist");
                    login.putExtra("userlist",arr);
                }
                else{
                login.putExtra("userlist",userService.getUserList());
                }
                startActivity(login);
        }});

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(context, RegisterActivity.class);
                Bundle b = getIntent().getExtras();
                if(b!=null){
                    ArrayList<User> arr = (ArrayList<User>)b.get("userlist");
                    register.putExtra("userlist",arr);
                }
                else{
                    register.putExtra("userlist", userService.getUserList());
                }
                startActivity(register);
            }
        });

    }

}
