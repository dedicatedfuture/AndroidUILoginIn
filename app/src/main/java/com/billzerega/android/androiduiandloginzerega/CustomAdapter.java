package com.billzerega.android.androiduiandloginzerega;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.billzerega.android.androiduiandloginzerega.model.entity.entity.UserProfile;

import org.w3c.dom.Text;

import java.util.List;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CardViewHolder> {
    private Context mCtx;
    private List<UserProfile> mUserProfiles;


    public CustomAdapter(Context ctx, List<UserProfile> userProfiles) {
        mCtx = ctx;
        mUserProfiles = userProfiles;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.custom_row, null);
        CardViewHolder holder = new CardViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        UserProfile userProfile = mUserProfiles.get(i);
        cardViewHolder.fNameTextView.setText(userProfile.getFirstName());
        cardViewHolder.uNameTextView.setText(userProfile.getUserName());
        cardViewHolder.emTextView.setText(userProfile.getEmail());
    }

    @Override
    public int getItemCount() {
        return mUserProfiles.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView uNameTextView;
        TextView fNameTextView;
        TextView emTextView;

        public CardViewHolder(View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardView);
            uNameTextView = (TextView) itemView.findViewById(R.id.userNameView);;
            fNameTextView = (TextView) itemView.findViewById(R.id.userFirstNameText);;
            emTextView = (TextView) itemView.findViewById(R.id.userEmailText);;
        }
    }



//    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        View listItemView = convertView;
//
//        if(listItemView == null){
//            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row, parent, false);
//
//        }
//
//        //grabbing the user profile for each position
//        UserProfile userProfile = (UserProfile) getItem(position);
//
//        //grabbing the 3 fields in the custom row, and then filling them with the info from hte userProfile
//        TextView userNameTextView = (TextView) listItemView.findViewById(R.id.userNameView);
//
//        userNameTextView.setText(userProfile.getUserName());
//
//        TextView firstNameTextView = (TextView) listItemView.findViewById(R.id.userFirstNameText);
//
//        firstNameTextView.setText(userProfile.getFirstName());
//
//        TextView emailTextView = (TextView) listItemView.findViewById(R.id.userEmailText);
//
//        emailTextView.setText(userProfile.getEmail());
//
//
//
//
//        return listItemView;
//    }
}
