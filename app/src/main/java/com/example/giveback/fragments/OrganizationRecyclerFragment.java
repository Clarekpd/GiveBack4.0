package com.example.giveback.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.giveback.OrganizationRecord;
import com.example.giveback.OrganizationRecordAdapter;
import com.example.giveback.R;
import com.example.giveback.TransactionRecord;
import com.example.giveback.TransactionRecordAdapter;

import java.util.ArrayList;

/**
 * This fragment represents a view that will display a recycler view containing transaction records.
 */
public class OrganizationRecyclerFragment extends Fragment {

    private ArrayList<OrganizationRecord> chris;
    private String title;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.recycler_content_org, container, false);
        RecyclerView recyclerView =  (RecyclerView) view.findViewById(R.id.rec_view);
        final FragmentActivity c = getActivity();
        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);

        // Don't change the size of the content
        recyclerView.setHasFixedSize(true);
        OrganizationRecordAdapter adapter = new OrganizationRecordAdapter(c, 9, chris);
        recyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle(title);
    }


    public ArrayList<OrganizationRecord> getChris() {
        return chris;
    }

    public void setChris(ArrayList<OrganizationRecord> data) {
        this.chris = chris;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
