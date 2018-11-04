package com.billzerega.android.androiduiandloginzerega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.billzerega.android.androiduiandloginzerega.model.entity.dao.UserProfilePersistence;
import com.billzerega.android.androiduiandloginzerega.model.entity.entity.UserProfile;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button mlogInButton;
    private Button mSignUpButton;
    private TextView mUserName;
    private TextView mPassword;
    private UserProfilePersistence database;
    ArrayList<UserProfile> userProfiles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlogInButton = (Button) findViewById(R.id.login_button);
        mSignUpButton = (Button) findViewById(R.id.signup_button);
        mUserName = (TextView) findViewById(R.id.username);
        mPassword = (TextView) findViewById(R.id.password);

        mlogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = new UserProfilePersistence(MainActivity.this);
                userProfiles = database.getDataFromDB();

                if(userProfiles.size() > 0){
                    //cycle through all of the users
                    for(UserProfile userP : userProfiles){
                        //check if entered username and password match to any in database
                        if((userP.getUserName().equals(mUserName.getText().toString())) &&
                                userP.getPassword().equals(mPassword.getText().toString())){
                            //if they do match pass to the log in success activity

                            Intent logInIntent = new Intent(MainActivity.this, LoginSuccessActivity.class);

                            String userFirstName = (String) userP.getFirstName();
                            String userLastName = (String) userP.getLastName();

                            logInIntent.putExtra("firstName", userFirstName);
                            logInIntent.putExtra("lastName", userLastName);

                            MainActivity.this.startActivity(logInIntent);

                        }else{
                            Toast.makeText(MainActivity.this, "Invalid username and/or password",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Create a new account", Toast.LENGTH_LONG).show();
                }

            }
        });

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });

    }
}
