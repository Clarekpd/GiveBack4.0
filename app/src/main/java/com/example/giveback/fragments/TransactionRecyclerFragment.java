package com.example.giveback.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.giveback.R;
import com.example.giveback.TransactionRecord;
import com.example.giveback.TransactionRecordAdapter;
import com.example.giveback.TransactionRecordPendingConfirmation;
import com.example.giveback.TransactionRecordPendingPickup;
import com.example.giveback.TransactionRecordPendingPickupDonor;

import java.util.ArrayList;

/**
 * This fragment represents a view that will display a recycler view containing transaction records.
 */
public class TransactionRecyclerFragment extends Fragment {

    private ArrayList<TransactionRecord> data;
    private String title;
    private Boolean isDonor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.recycler_content, container, false);
        RecyclerView recyclerView =  (RecyclerView) view.findViewById(R.id.rec_view);
        final FragmentActivity c = getActivity();
        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);

        // Don't change the size of the content
        recyclerView.setHasFixedSize(true);
        if(title.equals("Pending Confirmation") && !isDonor)
        {
            TransactionRecordPendingConfirmation adapter = new TransactionRecordPendingConfirmation(c, 9, data);
            recyclerView.setAdapter(adapter);
        }
        else if(title.equals("Pending Pickup") && !isDonor)
        {
            TransactionRecordPendingPickup adapter = new TransactionRecordPendingPickup(c, 9, data);
            recyclerView.setAdapter(adapter);
        }
        else if(title.equals("Pending Pickup") && isDonor)
        {
            TransactionRecordPendingPickupDonor adapter = new TransactionRecordPendingPickupDonor(c, 9, data);
            recyclerView.setAdapter(adapter);
        }
        else
        {
            TransactionRecordAdapter adapter = new TransactionRecordAdapter(c, 9, data);
            recyclerView.setAdapter(adapter);
        }


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle(title);
    }


    public ArrayList<TransactionRecord> getData() {
        return data;
    }

    public void setData(ArrayList<TransactionRecord> data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDonor() { return isDonor; }

    public void setDonor(Boolean donor) { isDonor = donor; }



}
