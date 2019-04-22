package com.example.giveback;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.giveback.fragments.SearchFragment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrgInfo extends AppCompatActivity {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_org);
        final OrganizationRecord organizationRecord = (OrganizationRecord)getIntent().getSerializableExtra("OrgSelected");

        TextView mTextNameMessage = (TextView) findViewById(R.id.orgNameOfficial);
        mTextNameMessage.setText(organizationRecord.getOrgNameOfficial());
        TextView mTextLocationMessage = (TextView) findViewById(R.id.location);
        mTextLocationMessage.setText(organizationRecord.getOrgNameOfficial());
        TextView mTextStateMessage = (TextView) findViewById(R.id.orgName);
        @SuppressLint("WrongViewCast") final Button websiteButton = findViewById(R.id.website);
        websiteButton.setText(organizationRecord.getWebsite());
        websiteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(organizationRecord.getWebsite()));
                startActivity(browserIntent);
            }
        });

        }
}