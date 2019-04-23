package com.example.giveback.fragments;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.giveback.AfterLogin;
import com.example.giveback.DonorRecord;
import com.example.giveback.DonorRecordAdapter;
import com.example.giveback.MainActivity;
import com.example.giveback.R;
import com.example.giveback.TransactionRecord;

import java.util.ArrayList;
import java.util.Calendar;

public class DonationRequestFragment extends Fragment {
    private String title;
    Bundle bundle = new Bundle();
    TimePickerDialog picker;
    EditText eText;
    EditText eText2;
    DatePickerDialog datePicker;




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
                Toast.makeText(view.getContext(), "Your request has been submitted", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(), AfterLogin.class);
                bundle.putBoolean("userType", true);
                bundle.putString("whereToGo", "pendCon");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        Button timeButton = (Button) view.findViewById(R.id.time_button);
        eText=(EditText) view.findViewById(R.id.timeText);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                picker = new TimePickerDialog(view.getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                eText.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();

            }
        });

        Button dateButton = (Button) view.findViewById(R.id.date_button);
        eText2=(EditText) view.findViewById(R.id.dateText);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int year = cldr.get(Calendar.YEAR);
                int month = cldr.get(Calendar.MONTH);
                // time picker dialog
                datePicker = new DatePickerDialog(view.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker tp, int year, int month, int day) {
                                eText2.setText(month + 1 + "/" + day + "/" + year);
                            }
                        }, year, month, day);
                datePicker.show();

            }
        });


        Spinner spinner = (Spinner) view.findViewById(R.id.org_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.org_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Spinner spinnerCat = (Spinner) view.findViewById(R.id.category_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterCat = ArrayAdapter.createFromResource(view.getContext(),
                R.array.category_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerCat.setAdapter(adapterCat);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private ArrayList<TransactionRecord> getPendingConfirmations() {
        ArrayList<TransactionRecord> data = new ArrayList<>();

        data.add(new TransactionRecord("food", "Are You Hungry","non-perishable goods, 4 jars of peanut butter","7779 Townline Rd, Eden Praire, MN","7-9:30 Tuesday Sep. 3","under the big oak tree on the front yard"));
        data.add(new TransactionRecord("clothes", "Are You Hungry","22 shirts of various sizes","2244 Glenbrook Rd N, Wayzata, MN", "9 pm Friday April 29","Check behind the pot of flowers"));
        data.add(new TransactionRecord("toy", "Toys For Kiddos","Lego Pieces-1000 piece set","3444 Vanhauser lane, Dayton, OH","5pm Any Monday until Jun 20","Ring my doorbell"));
        data.add(new TransactionRecord("furniture", "Orange Spatula","I have an extra couch","6789 Bedford trail, Roseville, TX","8 P.M. Monday July 23","Ring the doorbell, I will open the garage for you to get the couch"));
        data.add(new TransactionRecord("clothes", "Are You Hungry","30 sets if brand new Jackets","2835 Addisen Ptwy, Inver Grove, MN","9 pm Tuesday","Check behind the bushes and the plants"));
        data.add(new TransactionRecord("food", "Are You Hungry","7 boxes of granola bars, 1 package of water","900 Glacier Ln N, Plymouth MN","8 pm on Thursday April 20.","Ring my doorbell, it is inside"));
        data.add(new TransactionRecord("furniture", "Orange Spatula","Old table","6743 pioneer Trail, eagan MN","9'o clock pm Sunday","none"));
        data.add(new TransactionRecord("hygiene", "Are You Hungry","30 toothbrushes","On the curb near the street turn for Fairvick and Marbella Rd","4pm Saturday Jun 13","under my tree"));
        data.add(new TransactionRecord("toys", "Toys For Kiddos","4 teddy bears","7428 Blue Haven Rd, 67421","6pm Monday 28 February","On my front steps"));

        return data;
    }
}
