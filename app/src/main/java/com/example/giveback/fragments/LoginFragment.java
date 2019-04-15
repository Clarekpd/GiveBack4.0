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

import com.example.giveback.R;
import com.example.giveback.TransactionRecord;
import com.example.giveback.TransactionRecordAdapter;

import java.util.ArrayList;

/**
 * This fragment represents a view that will display a recycler view containing transaction records.
 */
public class LoginFragment extends Fragment {

    private ArrayList<TransactionRecord> data;
    private String title;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.login_activity, container, false);

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

}
