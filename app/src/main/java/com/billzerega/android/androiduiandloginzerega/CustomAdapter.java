package com.billzerega.android.androiduiandloginzerega;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.billzerega.android.androiduiandloginzerega.model.entity.entity.UserProfile;

import java.util.List;

class CustomAdapter extends ArrayAdapter {
    public CustomAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row, parent, false);

        }

        //grabbing the user profile for each position
        UserProfile userProfile = (UserProfile) getItem(position);

        //grabbing the 3 fields in the custom row, and then filling them with the info from hte userProfile
        TextView userNameTextView = (TextView) listItemView.findViewById(R.id.userNameView);

        userNameTextView.setText(userProfile.getUserName());

        TextView firstNameTextView = (TextView) listItemView.findViewById(R.id.userFirstNameText);

        firstNameTextView.setText(userProfile.getFirstName());

        TextView emailTextView = (TextView) listItemView.findViewById(R.id.userEmailText);

        emailTextView.setText(userProfile.getEmail());




        return listItemView;
    }
}
