package com.example.giveback;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class DonationRequestAdapter extends RecyclerView.Adapter<DonationRequestAdapter.RequestViewHolder> {

    public class RequestViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView = (RecyclerView) itemView.findViewById(R.id.donation_request);

        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

        @Override
        public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            Context context = viewGroup.getContext();
            int layoutIdForListItem = R.layout.donation_request;

            RecyclerView recyclerView;

            LayoutInflater inflater = LayoutInflater.from(context);

            View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
            RequestViewHolder viewHolder = new RequestViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RequestViewHolder requestViewHolder, int i) {

            RecyclerView thisRecyclerView = requestViewHolder.recyclerView;

            TextView descriptionLabelText = (TextView) thisRecyclerView.findViewById(R.id.descriptionLabel);

            EditText descriptionText = (EditText) thisRecyclerView.findViewById(R.id.description);

            TextView dimensionsLabelText = (TextView) thisRecyclerView.findViewById(R.id.dimensionLabel);

            EditText dimensionsText = (EditText) thisRecyclerView.findViewById(R.id.dimensions);

            TextView itemsLabelText = (TextView) thisRecyclerView.findViewById(R.id.itemsLabel);

            EditText itemsText = (EditText) thisRecyclerView.findViewById(R.id.items);

            TextView locationLabelText = (TextView) thisRecyclerView.findViewById(R.id.locationLabel);

            EditText locationText = (EditText) thisRecyclerView.findViewById(R.id.location);

            TextView specialIntructionsLabelText = (TextView) thisRecyclerView.findViewById(R.id.specialInstructionsLabel);

            EditText specialIntrusctionsText = (EditText) thisRecyclerView.findViewById(R.id.specialInstructions);

            TextView numberOfItemsLabelText = (TextView) thisRecyclerView.findViewById(R.id.numberOfItemsLabel);

            TextView orgNamesLabelText = (TextView) thisRecyclerView.findViewById(R.id.orgNamesLabel);

            EditText orgNameText = (EditText) thisRecyclerView.findViewById(R.id.orgName);
        }

        @Override
        public int getItemCount() {
            return 0;
        }


}