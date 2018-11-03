package com.billzerega.android.androiduiandloginzerega;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String> {
    public CustomAdapter(Context context, int resource) {
        super(context, resource);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row, parent, false);

        }



        LayoutInflater userInflater = LayoutInflater.from(getContext());

        View customView = userInflater.inflate(R.layout.custom_row, parent, false);

        String singleuser = getItem(position);
        TextView userNameText = (TextView) customView.findViewById(R.id.userNameView);
        TextView userFirstNameText = (TextView) customView.findViewById(R.id.userFirstNameText);

        userNameText.setText(singleuser);
        userFirstNameText.setText(singleuser);

        return customView;
    }
}
