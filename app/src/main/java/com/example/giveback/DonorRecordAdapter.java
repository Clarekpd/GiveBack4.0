package com.example.giveback;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DonorRecordAdapter extends RecyclerView.Adapter<DonorRecordAdapter.DonorViewHolder> {


    private Context context;
    private  ArrayList<DonorRecord> bob;
    private int numItems;

    public class DonorViewHolder extends RecyclerView.ViewHolder {


        // Create a TextView variable called listItemNumberView
        CardView cardView = (CardView) itemView.findViewById(R.id.donor_card_view);


        // Create a constructor for NewsViewHolder that accepts a View called itemView as a parameter

        public DonorViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.donor_card_view);
        }

    }

    public DonorRecordAdapter(Context con, int number, ArrayList<DonorRecord> arrList) {

        context = con;
        bob = arrList;
        numItems = number;

    }





    @NonNull
    @Override
    public DonorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.donor_card;

        // Inflate our new item view using a LayoutInflater. It takes the ID of layout in xml.
        // Then --> inflates or converts this collection of view groups and views.
        LayoutInflater inflater = LayoutInflater.from(context);


        // Set to false, so that the inflated layout will not be
        // immediately attached to its parent viewgroup.
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        DonorViewHolder viewHolder = new DonorViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DonorViewHolder transactionViewHolder, int i) {
        // Get the data model based on position

        DonorRecord record = bob.get(i);
        // Set item views based on your views and data model
        CardView thisCardView = transactionViewHolder.cardView;

        TextView categoryText = (TextView) thisCardView.findViewById(R.id.donorName);
        categoryText.setText(record.getDonorName());

        TextView orgNameText = (TextView) thisCardView.findViewById(R.id.address);
        orgNameText.setText(record.getAddress());

        TextView donationInfoText = (TextView) thisCardView.findViewById(R.id.contactInfoDonor);
        donationInfoText.setText(record.getContactInfoDonor());

        TextView locationText = (TextView) thisCardView.findViewById(R.id.loginDonor);
        locationText.setText(record.getLoginDonor());

        TextView timeText = (TextView) thisCardView.findViewById(R.id.idDonor);
        timeText.setText(record.getIdDonor());

        TextView tagText = (TextView) thisCardView.findViewById(R.id.numberOfItems);
        tagText.setText(record.getNumberOfItems());
    }

    @Override
    public int getItemCount() {
        return bob.size();
    }



}
