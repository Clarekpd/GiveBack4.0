package com.example.giveback;

import android.app.NotificationManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class TransactionRecordPendingConfirmation extends RecyclerView.Adapter<TransactionRecordPendingConfirmation.TransactionViewHolder> {


    private Context context;

    private  ArrayList<TransactionRecord> data;
    private int numItems;

    private Button acceptButton;
    private Button denyButton;


    public class TransactionViewHolder extends RecyclerView.ViewHolder {


        // Create a TextView variable called listItemNumberView
        CardView cardView = (CardView) itemView.findViewById(R.id.transaction_card_view_org_pc);


        // Create a constructor for NewsViewHolder that accepts a View called itemView as a parameter
        public TransactionViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.transaction_card_view_org_pc);

            acceptButton = (Button) itemView.findViewById(R.id.accept);
            acceptButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "The donor has been notified that their pick-up has been verified.", Toast.LENGTH_SHORT).show();
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(view.getContext())
                            .setSmallIcon(R.drawable.connect)
                            .setContentTitle("Request Notification")
                            .setContentText("Your donation request has been accepted.");
                    // Add as notification
                    NotificationManager manager = (NotificationManager)view.getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                    manager.notify(0, builder.build());
                }
            });

            denyButton = (Button) itemView.findViewById(R.id.deny);
            denyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "The donor has been notified that their pick-up has been canceled.", Toast.LENGTH_SHORT).show();
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(view.getContext())
                            .setSmallIcon(R.drawable.connect)
                            .setContentTitle("Request Notification")
                            .setContentText("Your donation request has been denied.");
                    // Add as notification
                    NotificationManager manager = (NotificationManager)view.getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                    manager.notify(0, builder.build());
                }
            });




        }



    }

    public TransactionRecordPendingConfirmation(Context con, int number, ArrayList<TransactionRecord> arrList) {

        context = con;
        data = arrList;
        numItems = number;

    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.transaction_card_org_pc;

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
        TextView categoryText = (TextView) thisCardView.findViewById(R.id.category_pc);
        categoryText.setText(record.getCategory());
        TextView orgNameText = (TextView) thisCardView.findViewById(R.id.orgName_pc);
        orgNameText.setText(record.getOrgName());
        TextView donationInfoText = (TextView) thisCardView.findViewById(R.id.donationInfo_pc);
        donationInfoText.setText(record.getDonation());
        TextView locationText = (TextView) thisCardView.findViewById(R.id.location_pc);
        locationText.setText(record.getLocation());
        TextView timeText = (TextView) thisCardView.findViewById(R.id.time_pc);
        timeText.setText(record.getTime());
        TextView tagText = (TextView) thisCardView.findViewById(R.id.tag_pc);
        tagText.setText(record.getTag());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}
