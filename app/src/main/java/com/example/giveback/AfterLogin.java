 package com.example.giveback;

import android.os.Bundle;
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

import com.example.giveback.fragments.DonationRequestFragment;
import com.example.giveback.fragments.LoginFragment;
import com.example.giveback.fragments.OrganizationRecyclerFragment;
import com.example.giveback.fragments.TransactionRecyclerFragment;
import com.example.giveback.fragments.DonorRecyclerFragment;

import java.util.ArrayList;

 public class AfterLogin extends AppCompatActivity {

     private Boolean userType;
     private Toolbar toolbar;
     private DrawerLayout drawer;
     private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get bundle and userType from MainActivity
        Bundle bundle = getIntent().getExtras();
        userType = bundle.getBoolean("userType");

        if(userType)
        {
            setContentView(R.layout.activity_main_donor);
            //creating fragment object
            Fragment fragment = null;

            fragment = new DonorRecyclerFragment();
            ((DonorRecyclerFragment) fragment).setDonorRecords(getDonorRecords());
            ((DonorRecyclerFragment) fragment).setTitle("My Information");


            //replacing the fragment with the one that was clicked on
            if (fragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        }
        else
        {
            setContentView(R.layout.activity_main_org);
            //creating fragment object
            Fragment fragment = null;

            fragment = new OrganizationRecyclerFragment();
            ((OrganizationRecyclerFragment) fragment).setOrgRecords(getOrganizationRecords());
            ((OrganizationRecyclerFragment) fragment).setTitle("My Information");


            //replacing the fragment with the one that was clicked on
            if (fragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        }




        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                        new NavigationView.OnNavigationItemSelectedListener() {
                            @Override
                            public boolean onNavigationItemSelected(MenuItem menuItem) {
                                selectNavigation(menuItem);
                                return true;
                            }});


        ////String acceptedCategories, String orgName, String login, String id, String pickUpRegions, String pickUpHours, String contactInfo, String orgDescription, String acceptedItems, String website, boolean verification, String advanceNoticeWindow, String logo
        //org record

        ArrayList<OrganizationRecord> chris = new ArrayList<>();
        chris.add(new OrganizationRecord("food, blankets, clothing, and hygiene products","Are You Hungry", "R U Hungry", "1", "Within 50 miles of Eden Prairie", "3pm-10pm", " contactruhungry@gmail.com", "We establish, expand access for healthy meal. The people we will be serving includes undernourished children, families on the brink of starvation, senior citizens. We want to ensure that everyone we serve gets 3 meals a day", "Granola Bars, Water, Soup, Peanut Butter", "http://www.ruhungry.us", true, "1 day", "Logo info"));




        ArrayList<DonorRecord> bob = new ArrayList<>();

        bob.add(new DonorRecord("Ash","Czech","ash_czech@gmail.com","password","Ash_Czezh123",1));
        bob.add(new DonorRecord("Nora","Barack","overlord@yopmail.com","password","Nora456",2));
        bob.add(new DonorRecord("Mary","Foran","676-676-87","password","forfor56",3));
        bob.add(new DonorRecord("Joe","Bob","jacks@outlook.com","password","joe1238",4));
        bob.add(new DonorRecord("Claire","Clare","bachmann@live.com","password","clareness",5));
        bob.add(new DonorRecord("Prapthi","Samsonite","123-456-78","password","77samsonite77",6));
        bob.add(new DonorRecord("Raphael","Solano","7890987","password","jane678",7));
        bob.add(new DonorRecord("Iris","Sirrkay","squirrel@icloud.com","password","guinea7",8));
        bob.add(new DonorRecord("Ellie","Hurdlehall","134-6786","password","ells",9));
        bob.add(new DonorRecord("Magda","Petra","oveputtah-0844@yopmail.com","password","xopo mag",10));

        DonorRecordAdapter adapter2 = new DonorRecordAdapter(getApplicationContext(), 10, bob);
        OrganizationRecordAdapter adapter1 = new OrganizationRecordAdapter(getApplicationContext(), 1, chris);


//        //creating fragment object
//        Fragment fragment = null;
//
//        fragment = new LoginFragment();
//        ((LoginFragment) fragment).setTitle("Login");
//
//
//        //replacing the fragment with the one that was clicked on
//        if (fragment != null) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.content_frame, fragment);
//            ft.commit();
//        }


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

    public void selectNavigation(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //creating fragment object
        Fragment fragment = null;


        //fragments that appear for both users
        if (id == R.id.nav_pending_conformation) {
            fragment = new TransactionRecyclerFragment();
            ((TransactionRecyclerFragment) fragment).setData(getPendingConfirmations());
            ((TransactionRecyclerFragment) fragment).setTitle("Pending Confirmation");
            ((TransactionRecyclerFragment) fragment).setDonor(userType);

        } else if (id == R.id.nav_pending_pickup) {
            fragment = new TransactionRecyclerFragment();
            ((TransactionRecyclerFragment) fragment).setData(getPendingPickupRecords());
            ((TransactionRecyclerFragment) fragment).setTitle("Pending Pickup");
            ((TransactionRecyclerFragment) fragment).setDonor(userType);
        } else if (id == R.id.nav_past_pickups) {
            fragment = new TransactionRecyclerFragment();
            ((TransactionRecyclerFragment) fragment).setData(getPickupHistoryRecords());
            ((TransactionRecyclerFragment) fragment).setTitle("Pickup History");
        }

        //fragments that only appear for orgs
        if(userType) {
            if (id == R.id.nav_donor_menu) {
                fragment = new DonorRecyclerFragment();
                ((DonorRecyclerFragment) fragment).setDonorRecords(getDonorRecords());
                ((DonorRecyclerFragment) fragment).setTitle("My Information");
            } else if (id == R.id.nav_donor_request) {
                fragment = new DonationRequestFragment();
                ((DonationRequestFragment) fragment).setTitle("Donation Request");
            }

        }

        //fragments that only appear for donors
        else {
            if (id == R.id.nav_org_menu) {
                fragment = new OrganizationRecyclerFragment();
                ((OrganizationRecyclerFragment) fragment).setOrgRecords(getOrganizationRecords());
                ((OrganizationRecyclerFragment) fragment).setTitle("My Information");
            }
            //TODO: add Organization Info navigation, New type of Fragment and layout for it, passing in org info
        }



        //replacing the fragment with the one that was clicked on
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        //return true;
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

         donorRecords.add(new DonorRecord("Megan Tol","123 Baker Street","tol123@gmail.com","tdy245","tol123",5));

         return donorRecords;
     }

}
