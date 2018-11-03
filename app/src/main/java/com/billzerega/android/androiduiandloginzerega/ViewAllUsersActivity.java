package com.billzerega.android.androiduiandloginzerega;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ViewAllUsersActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);

        String[] usersArray = {"Bill", "Brandon", "Joe"};

//        ListAdapter usersAdapter = new CustomAdapter(this, usersArray);
//        ListView usersListView = (ListView) findViewById(R.id.usersListView);
//        usersListView.setAdapter(usersAdapter);
    }
}
