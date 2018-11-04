package com.billzerega.android.androiduiandloginzerega;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.billzerega.android.androiduiandloginzerega.model.entity.dao.UserProfilePersistence;
import com.billzerega.android.androiduiandloginzerega.model.entity.entity.UserProfile;

import java.util.ArrayList;

public class ViewAllUsersActivity extends AppCompatActivity {
    private ListView listViewUsersCategory;
    private CustomAdapter userAdapter;
    private ArrayList<UserProfile> userProfiles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);

        listViewUsersCategory = (ListView) findViewById(R.id.list_view_user_category);

        //user profile persistence used to interact with the database
        UserProfilePersistence userProfilePersistence = new UserProfilePersistence(this);

        userProfiles = userProfilePersistence.getDataFromDB();
        Toast.makeText(ViewAllUsersActivity.this, "Users in DB: " + userProfiles.size(),
                Toast.LENGTH_LONG).show();;
        userAdapter = new CustomAdapter(this, R.layout.custom_row, userProfiles);

        listViewUsersCategory.setAdapter(userAdapter);

        listViewUsersCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserProfile userProfile = (UserProfile) listViewUsersCategory.getItemAtPosition(position);
                Intent intent = new Intent(ViewAllUsersActivity.this, UserDetailsActivity.class);
                intent.putExtra("firstName", userProfile.getFirstName());
                intent.putExtra("lastName", userProfile.getLastName());
                intent.putExtra("userName", userProfile.getUserName());

                startActivity(intent);
            }
        });





//        ListAdapter usersAdapter = new CustomAdapter(this, usersArray);
//        ListView usersListView = (ListView) findViewById(R.id.usersListView);
//        usersListView.setAdapter(usersAdapter);
    }
}
