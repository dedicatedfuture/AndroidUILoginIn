package com.billzerega.android.androiduiandloginzerega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.billzerega.android.androiduiandloginzerega.model.entity.dao.UserProfilePersistence;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button mlogInButton;
    private Button mSignUpButton;
    private TextView mUserName;
    private TextView mPassword;
    private UserProfilePersistence database = new UserProfilePersistence(this);



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
                Intent logInIntent = new Intent(MainActivity.this, LoginSuccessActivity.class);




                String userFirstName = (String) "bill" ;//call to database ;
                String userLastName = (String) "z";//call to database;

                logInIntent.putExtra("firstName", userFirstName);
                logInIntent.putExtra("lastName", userLastName);

                MainActivity.this.startActivity(logInIntent);


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
