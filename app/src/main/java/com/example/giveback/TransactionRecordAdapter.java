package com.example.giveback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionRecordAdapter extends RecyclerView.Adapter<TransactionRecordAdapter.TransactionViewHolder> {


    private Context context;
    private  ArrayList<TransactionRecord> data;
    private int numItems;

    public class TransactionViewHolder extends RecyclerView.ViewHolder {


        // Create a TextView variable called listItemNumberView
        CardView cardView = (CardView) itemView.findViewById(R.id.transaction_card_view);


        // Create a constructor for NewsViewHolder that accepts a View called itemView as a parameter

        public TransactionViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.transaction_card_view);
        }

    }

    public TransactionRecordAdapter(Context con, int number, ArrayList<TransactionRecord> arrList) {

        context = con;
        data = arrList;
        numItems = number;

    }





    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.transaction_card;

        // Inflate our new item view using a LayoutInflater. It takes the ID of layout in xml.
        // Then --> inflates or converts this collection of view groups and views.
        LayoutInflater inflater = LayoutInflater.from(context);


        // Set to false, so that the inflated layout will not be
        // immediately attached to its parent viewgroup.
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        TransactionViewHolder viewHolder = new TransactionViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder transactionViewHolder, int i) {
        // Get the data model based on position

        TransactionRecord record = data.get(i);
        // Set item views based on your views and data model
        CardView thisCardView = transactionViewHolder.cardView;
        TextView categoryText = (TextView) thisCardView.findViewById(R.id.category);
        categoryText.setText(record.getCategory());
        TextView orgNameText = (TextView) thisCardView.findViewById(R.id.orgName);
        orgNameText.setText(record.getOrgName());
        TextView donationInfoText = (TextView) thisCardView.findViewById(R.id.donationInfo);
        donationInfoText.setText(record.getDonation());
        TextView locationText = (TextView) thisCardView.findViewById(R.id.location);
        locationText.setText(record.getLocation());
        TextView timeText = (TextView) thisCardView.findViewById(R.id.time);
        timeText.setText(record.getTime());
        TextView tagText = (TextView) thisCardView.findViewById(R.id.tag);
        tagText.setText(record.getTag());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}
