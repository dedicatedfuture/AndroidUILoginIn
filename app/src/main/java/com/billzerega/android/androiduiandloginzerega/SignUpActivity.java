package com.billzerega.android.androiduiandloginzerega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.billzerega.android.androiduiandloginzerega.model.entity.dao.UserProfilePersistence;
import com.billzerega.android.androiduiandloginzerega.model.entity.entity.UserProfile;

public class SignUpActivity extends AppCompatActivity {
    private Button mConfirm;
    private EditText mBirthday;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mUserName;
    private EditText mPhoneNumber;
    private EditText mEmail;
    private EditText mCreatePassword;
    private  UserProfilePersistence database = new UserProfilePersistence(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mConfirm = (Button) findViewById(R.id.confirm);
        mFirstName = (EditText) findViewById(R.id.firstName);
        mLastName = (EditText) findViewById(R.id.lastName);
        mBirthday = (EditText) findViewById(R.id.birthday);
        mUserName = (EditText) findViewById(R.id.userName);
        mPhoneNumber = (EditText) findViewById(R.id.phoneNumber);
        mEmail = (EditText) findViewById(R.id.email);
        mCreatePassword = (EditText) findViewById(R.id.createPassword);



        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add users profile to the database



                String firstName = mFirstName.getText().toString();
                String lastName = mLastName.getText().toString();
                String birthday = mBirthday.getText().toString();
                String userName = mUserName.getText().toString();
                String phoneNumber = mPhoneNumber.getText().toString();
                String email = mEmail.getText().toString();
                String password = mCreatePassword.getText().toString();

                UserProfile newUserProfile = new UserProfile(firstName, lastName,  userName, birthday, phoneNumber,
                                                            email, password);
                Log.d("inersting into database", newUserProfile.toString());
                database.insert(newUserProfile);






                //create the intent with extras for personalized greeting
                Intent logInIntent = new Intent(SignUpActivity.this, LoginSuccessActivity.class);

                String userFirstName = mFirstName.getText().toString();
                String userLastName = mLastName.getText().toString();

                logInIntent.putExtra("firstName", userFirstName);
                logInIntent.putExtra("lastName", userLastName);

                SignUpActivity.this.startActivity(logInIntent);

                Toast toast = Toast.makeText(getApplicationContext(), "User Successfully Created", Toast.LENGTH_LONG);
                toast.show();


            }
        });
    }
}
