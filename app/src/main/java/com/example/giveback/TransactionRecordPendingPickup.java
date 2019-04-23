package com.example.giveback;

import android.app.NotificationManager;
import android.content.Context;
import android.media.MediaPlayer;
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


public class TransactionRecordPendingPickup extends RecyclerView.Adapter<TransactionRecordPendingPickup.TransactionViewHolder> {


    private Context context;

    private  ArrayList<TransactionRecord> data;
    private int numItems;

    private Button verifyButton;
    private Button cancelButton;


    public class TransactionViewHolder extends RecyclerView.ViewHolder {


        // Create a TextView variable called listItemNumberView
        CardView cardView = (CardView) itemView.findViewById(R.id.transaction_card_view_org_pp);

        //ding sound
        final MediaPlayer ding = MediaPlayer.create(context, R.raw.ding);


        // Create a constructor for NewsViewHolder that accepts a View called itemView as a parameter
        public TransactionViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.transaction_card_view_org_pp);

            verifyButton = (Button) itemView.findViewById(R.id.verify);
            verifyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "The donor has been notified that their pick-up has been completed.", Toast.LENGTH_SHORT).show();
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(view.getContext())
                            .setSmallIcon(R.drawable.connect)
                            .setContentTitle("Verification Notification")
                            .setContentText("Your pick-up has been completed.");
                    // Add as notification
                    NotificationManager manager = (NotificationManager)view.getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                    manager.notify(0, builder.build());

                    ding.start();
                }
            });

            cancelButton = (Button) itemView.findViewById(R.id.cancel);
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "The donor has been notified that their pick-up has been canceled.", Toast.LENGTH_SHORT).show();
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(view.getContext())
                            .setSmallIcon(R.drawable.connect)
                            .setContentTitle("Verification Notification")
                            .setContentText("Your pick-up has been canceled.");
                    // Add as notification
                    NotificationManager manager = (NotificationManager)view.getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                    manager.notify(0, builder.build());

                    ding.start();
                }
            });




        }



    }

    public TransactionRecordPendingPickup(Context con, int number, ArrayList<TransactionRecord> arrList) {

        context = con;
        data = arrList;
        numItems = number;

    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.transaction_card_org_pp;

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
        TextView categoryText = (TextView) thisCardView.findViewById(R.id.category_pp);
        categoryText.setText(record.getCategory());
       /* TextView orgNameText = (TextView) thisCardView.findViewById(R.id.orgName_pp);
        orgNameText.setText(record.getOrgName());*/
        TextView donationInfoText = (TextView) thisCardView.findViewById(R.id.donationInfo_pp);
        donationInfoText.setText(record.getDonation());
        TextView locationText = (TextView) thisCardView.findViewById(R.id.location_pp);
        locationText.setText(record.getLocation());
        TextView timeText = (TextView) thisCardView.findViewById(R.id.time_pp);
        timeText.setText(record.getTime());
        TextView tagText = (TextView) thisCardView.findViewById(R.id.tag_pp);
        tagText.setText(record.getTag());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}
