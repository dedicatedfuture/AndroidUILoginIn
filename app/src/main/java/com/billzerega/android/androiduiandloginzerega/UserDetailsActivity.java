package com.billzerega.android.androiduiandloginzerega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetailsActivity extends AppCompatActivity {
    private TextView userDetailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        userDetailTextView = (TextView) findViewById(R.id.userDetailsTextView);

        Intent intent = getIntent();

        String firstname = intent.getStringExtra("firstName");
        String lastname = intent.getStringExtra("lastName");
        String username = intent.getStringExtra("userName");

        StringBuilder builder = new StringBuilder(50);
        builder.append("User: "+firstname);
        builder.append(" "+lastname+" ");
        builder.append("Username: "+username);
        userDetailTextView.setText(builder);
    }
}
