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

public class OrganizationRecordAdapter extends RecyclerView.Adapter<OrganizationRecordAdapter.OrganizationViewHolder> {


    private Context context;
    private  ArrayList<OrganizationRecord> orgRecords;
    private int numItems;

    public class OrganizationViewHolder extends RecyclerView.ViewHolder {


        // Create a TextView variable called listItemNumberView
        CardView cardView = (CardView) itemView.findViewById(R.id.organization_card_view);


        // Create a constructor for NewsViewHolder that accepts a View called itemView as a parameter

        public OrganizationViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.organization_card_view);
        }

    }

    public OrganizationRecordAdapter(Context con, int number, ArrayList<OrganizationRecord> arrList) {

        context = con;
        orgRecords = arrList;
        numItems = number;

    }





    @NonNull
    @Override
    public OrganizationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.organization_card;

        // Inflate our new item view using a LayoutInflater. It takes the ID of layout in xml.
        // Then --> inflates or converts this collection of view groups and views.
        LayoutInflater inflater = LayoutInflater.from(context);


        // Set to false, so that the inflated layout will not be
        // immediately attached to its parent viewgroup.
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        OrganizationViewHolder viewHolder = new OrganizationViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrganizationViewHolder organizationViewHolder, int i) {
        // Get the data model based on position

        OrganizationRecord record = orgRecords.get(i);
        // Set item views based on your views and data model
        CardView thisCardView = organizationViewHolder.cardView;


        TextView acceptedCategoriesText = (TextView) thisCardView.findViewById(R.id.acceptedCategories);
        acceptedCategoriesText.setText(record.getAcceptedCategories());

        TextView orgNameOfficialText = (TextView) thisCardView.findViewById(R.id.orgNameOfficial);
        orgNameOfficialText.setText(record.getOrgNameOfficial());

        //TextView loginText = (TextView) thisCardView.findViewById(R.id.loginOrg);
        //loginText.setText(record.getLoginOrg());

        //TextView idText = (TextView) thisCardView.findViewById(R.id.idOrg);
        //idText.setText(record.getIdOrg());

        TextView pickUpRegionsText = (TextView) thisCardView.findViewById(R.id.pickUpRegions);
        pickUpRegionsText.setText(record.getPickUpRegions());

        TextView pickUpHoursText = (TextView) thisCardView.findViewById(R.id.pickUpHours);
        pickUpHoursText.setText(record.getPickUpHours());

        TextView contactInfoText = (TextView) thisCardView.findViewById(R.id.contactInfoOrg);
        contactInfoText.setText(record.getContactInfoOrg());

        TextView orgDescriptionText = (TextView) thisCardView.findViewById(R.id.orgDescription);
        orgDescriptionText.setText(record.getOrgDescription());

        TextView acceptedItemsText = (TextView) thisCardView.findViewById(R.id.acceptedItems);
        acceptedItemsText.setText(record.getAcceptedItems());

        TextView websiteText = (TextView) thisCardView.findViewById(R.id.website);
        websiteText.setText(record.getWebsite());

        //TextView verificationText = (TextView) thisCardView.findViewById(R.id.verification);
        //verificationText.setText(Boolean.valueOf(record.getVerification()).toString());

        TextView advanceNoticeWindowText = (TextView) thisCardView.findViewById(R.id.advanceNoticeWindow);
        advanceNoticeWindowText.setText(record.getAdvanceNoticeWindow());

        TextView logoText = (TextView) thisCardView.findViewById(R.id.logo);
        logoText.setText(record.getLogo());

    }

    @Override
    public int getItemCount() {
        return orgRecords.size();
    }



}
