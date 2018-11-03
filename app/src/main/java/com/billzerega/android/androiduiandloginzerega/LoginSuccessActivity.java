package com.billzerega.android.androiduiandloginzerega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginSuccessActivity extends AppCompatActivity {
    private Button viewAllUsersButton;
    private TextView greeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        viewAllUsersButton = (Button) findViewById(R.id.viewAllUsersButton);
        greeting = (TextView) findViewById(R.id.greeting);

        Intent logInIntent = getIntent();
        String firstName = getIntent().getExtras().getString("firstName");
        String lastName = getIntent().getExtras().getString("lastName");

        greeting.setText("Welcome " + firstName + " " + lastName);

        viewAllUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewAllUsersIntent = new Intent(LoginSuccessActivity.this, ViewAllUsersActivity.class);
                LoginSuccessActivity.this.startActivity(viewAllUsersIntent);
            }
        });






    }


}
