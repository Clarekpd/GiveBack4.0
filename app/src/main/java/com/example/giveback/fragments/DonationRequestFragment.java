package com.example.giveback.fragments;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.giveback.DonorRecord;
import com.example.giveback.DonorRecordAdapter;
import com.example.giveback.R;

import java.util.ArrayList;

public class DonationRequestFragment extends Fragment {
    private String title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.donation_request, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle(title);

        Button submitButton = (Button) view.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "ahhhhhh.", Toast.LENGTH_SHORT).show();
               /* NotificationCompat.Builder builder = new NotificationCompat.Builder(view.getContext())
                        .setSmallIcon(R.drawable.connect)
                        .setContentTitle("Request Notification")
                        .setContentText("Your donation request has been accepted.");
                // Add as notification
                NotificationManager manager = (NotificationManager)view.getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0, builder.build());*/
            }
        });

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
