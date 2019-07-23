package com.example.giveback.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giveback.OrganizationRecord;
import com.example.giveback.OrganizationRecordAdapter;
import com.example.giveback.R;

import java.util.ArrayList;

/**
 * This fragment represents a view that will display a recycler view containing transaction records.
 */
public class OrganizationRecyclerFragment extends Fragment {

    private ArrayList<OrganizationRecord> orgRecords;
    private String title;


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
        OrganizationRecordAdapter adapter = new OrganizationRecordAdapter(c, 9, orgRecords);
        recyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle(title);
    }


    public ArrayList<OrganizationRecord> getOrgRecords() {
        return orgRecords;
    }

    public void setOrgRecords(ArrayList<OrganizationRecord> orgRecords) { this.orgRecords = orgRecords; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
