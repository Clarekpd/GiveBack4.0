 package com.example.giveback;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.giveback.fragments.LoginFragment;
import com.example.giveback.fragments.OrganizationRecyclerFragment;
import com.example.giveback.fragments.TransactionRecyclerFragment;
import com.example.giveback.fragments.DonorRecyclerFragment;

import java.util.ArrayList;
import java.util.List;

 public class AfterLogin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        ////String acceptedCategories, String orgName, String login, String id, String pickUpRegions, String pickUpHours, String contactInfo, String orgDescription, String acceptedItems, String website, boolean verification, String advanceNoticeWindow, String logo
        //org record

        ArrayList<OrganizationRecord> chris = new ArrayList<>();
        chris.add(new OrganizationRecord("food, blankets, clothing, and hygiene products","Are You Hungry", "R U Hungry", "1", "Within 50 miles of Eden Prairie", "3pm-10pm", " contactruhungry@gmail.com", "We establish, expand access for healthy meal. The people we will be serving includes undernourished children, families on the brink of starvation, senior citizens. We want to ensure that everyone we serve gets 3 meals a day", "Granola Bars, Water, Soup, Peanut Butter", "http://www.ruhungry.us", true, "1 day", "Logo info"));




        ArrayList<DonorRecord> bob = new ArrayList<>();

        bob.add(new DonorRecord("Ash","Czech","ash_czech@gmail.com","e","o",1));
        bob.add(new DonorRecord("Nora","Barack","v","f","p",2));
        bob.add(new DonorRecord("Mary","Foran","w","g","q",3));
        bob.add(new DonorRecord("Joe","Bob","x","h","r",4));
        bob.add(new DonorRecord("Claire","Clare","y","i","s",5));
        bob.add(new DonorRecord("Prapthi","Samsonite","z","j","t",6));
        bob.add(new DonorRecord("Raphael","Solano","a","k","u",7));
        bob.add(new DonorRecord("Iris","Sirrkay","b","l","v",8));
        bob.add(new DonorRecord("Ellie","Hurdlehall","c","m","w",9));
        bob.add(new DonorRecord("Magda","Petra","d","n","x",10));


        DonorRecordAdapter adapter2 = new DonorRecordAdapter(getApplicationContext(), 10, bob);
        OrganizationRecordAdapter adapter1 = new OrganizationRecordAdapter(getApplicationContext(), 1, chris);


        //creating fragment object
        Fragment fragment = null;

        fragment = new LoginFragment();
        ((LoginFragment) fragment).setTitle("Login");


        //replacing the fragment with the one that was clicked on
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //creating fragment object
        Fragment fragment = null;

        if (id == R.id.nav_pending_conformation) {
            fragment = new TransactionRecyclerFragment();
            ((TransactionRecyclerFragment) fragment).setData(getPendingConfirmations());
            ((TransactionRecyclerFragment) fragment).setTitle("Pending Confirmation");

        } else if (id == R.id.nav_pending_pickup) {
            fragment = new TransactionRecyclerFragment();
            ((TransactionRecyclerFragment) fragment).setData(getPendingPickupRecords());
            ((TransactionRecyclerFragment) fragment).setTitle("Pending Pickup");
        } else if (id == R.id.nav_past_pickups) {
            fragment = new TransactionRecyclerFragment();
            ((TransactionRecyclerFragment) fragment).setData(getPickupHistoryRecords());
            ((TransactionRecyclerFragment) fragment).setTitle("Pickup History");
        }else if (id == R.id.nav_org_menu) {
            fragment = new OrganizationRecyclerFragment();
            ((OrganizationRecyclerFragment) fragment).setOrgRecords(getOrganizationRecords());
            ((OrganizationRecyclerFragment) fragment).setTitle("My Information");
        }
        //TODO: add Organization Info navigation, New type of Fragment and layout for it, passing in org info
        else if (id == R.id.nav_donor_menu) {
            fragment = new DonorRecyclerFragment();
            ((DonorRecyclerFragment) fragment).setDonorRecords(getDonorRecords());
            ((DonorRecyclerFragment) fragment).setTitle("My Information");
        } else if (id == R.id.nav_donor_request) {
            fragment = new DonorRecyclerFragment();
            ((DonorRecyclerFragment) fragment).setTitle("Donation Request");
        }



        //replacing the fragment with the one that was clicked on
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




     /**
      * Get the pending confirmations for the current organization (currently hardcoded)
      * TODO: have it take in an org Name and only return those items.
      * @return
      */
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

     /**
      * Get the pending confirmations for the current organization (currently hardcoded)
      * TODO: have it take in an org Name and only return those items.
      * @return
      */
     private ArrayList<TransactionRecord> getPendingPickupRecords() {
         ArrayList<TransactionRecord> data = new ArrayList<>();

         data.add(new TransactionRecord("food", "FeedMe","tacos","I'm in your house","7-9:30 Tuesday Sep. 3","under the tree"));
         data.add(new TransactionRecord("clothes", "FeedMe","t-shirts","I'm in your house","7-9:30 Tuesday Sep. 3","under the tree"));

         return data;
     }

     /**
      * Get the pending confirmations for the current organization (currently hardcoded)
      * TODO: have it take in an org Name and only return those items.
      * @return
      */
     private ArrayList<TransactionRecord> getPickupHistoryRecords() {
         ArrayList<TransactionRecord> data = new ArrayList<>();

         data.add(new TransactionRecord("food", "Are You Hungry?","14 jars of Peanut Butter","9867 chestnut lane, eagan MN","7-9:30 Tuesday Sep. 3","under the tree"));

         return data;
     }
     private ArrayList<OrganizationRecord> getOrganizationRecords() {
         ArrayList<OrganizationRecord> orgRecords = new ArrayList<>();
         orgRecords.add(new OrganizationRecord("food, blankets, clothing, and hygiene products","Are You Hungry", "R U Hungry", "1", "Within 50 miles of Eden Prairie", "3pm-10pm", "contactruhungry@gmail.com", "We establish, expand access for healthy meal. The people we will be serving includes undernourished children, families on the brink of starvation, senior citizens. We want to ensure that everyone we serve gets 3 meals a day", "Granola Bars, Water, Soup, Peanut Butter", "http://www.ruhungry.us", true, "1 day", "Logo info"));
         return orgRecords;
     }

     private ArrayList<DonorRecord> getDonorRecords() {
         ArrayList<DonorRecord> donorRecords = new ArrayList<>();

         donorRecords.add(new DonorRecord("Ashley","Chen","u","e","o",1));

         return donorRecords;
     }

}
