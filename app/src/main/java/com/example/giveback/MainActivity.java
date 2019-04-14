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

import com.example.giveback.fragments.TransactionRecyclerFragment;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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
        chris.add(new OrganizationRecord("food, blankets, clothing, and hygiene products","Are You Hungry", "R U Hungry", 1, "Within 50 miles of Eden Prairie", "3pm-10pm", " contactruhungry@gmail.com", "We establish, expand access for healthy meal. The people we will be serving includes undernourished children, families on the brink of starvation, senior citizens. We want to ensure that everyone we serve gets 3 meals a day", "Granola Bars, Water, Soup, Peanut Butter", "http://www.ruhungry.us", true, "1 day", "Logo info"));




        ArrayList<DonorRecord> bob = new ArrayList<>();

        bob.add(new DonorRecord("a","k","u","e","o",1));
        bob.add(new DonorRecord("b","l","v","f","p",2));
        bob.add(new DonorRecord("c","m","w","g","q",3));
        bob.add(new DonorRecord("d","n","x","h","r",4));
        bob.add(new DonorRecord("e","o","y","i","s",5));
        bob.add(new DonorRecord("f","p","z","j","t",6));
        bob.add(new DonorRecord("g","q","a","k","u",7));
        bob.add(new DonorRecord("h","r","b","l","v",8));
        bob.add(new DonorRecord("i","s","c","m","w",9));
        bob.add(new DonorRecord("j","t","d","n","x",10));


        DonorRecordAdapter adapter2 = new DonorRecordAdapter(getApplicationContext(), 10, bob);
        OrganizationRecordAdapter adapter1 = new OrganizationRecordAdapter(getApplicationContext(), 1, chris);

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
        }
        //TODO: add Organization Info navigation, New type of Fragment and layout for it, passing in org info



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

        data.add(new TransactionRecord("food", "FeedMe","non- perishable goods","7779 Trucker Dr N, Austin, Tx","7-9:30 Tuesday Sep. 3","under the tree"));
        data.add(new TransactionRecord("clothes", "ClothMe","covered in goo","in my ufo","space time or Earth time","The password is 1234goose"));
        data.add(new TransactionRecord("animals", "AnimalMe","It is a live goose","my barnyard","5'o clock","I have a moat"));
        data.add(new TransactionRecord("food", "FeedMe2","I have extra asparagus","At my asparagus farm","8 P.M.","You can just ignore the asparagus"));
        data.add(new TransactionRecord("clothes", "ClothMe2","These clothes aren't covered in goo","Roswell, New Mexico","Midnight","We're 100% human"));
        data.add(new TransactionRecord("animals", "AnimalMe2","It's not cows","My milk farm","1 A.M.","They are live cows"));
        data.add(new TransactionRecord("food", "FeedMe3","Soup, other non-perishable items","Soup factory","3'o clock","vvvvvvvvv"));
        data.add(new TransactionRecord("clothes", "ClothMe3","vvvvvvvvvvv","xxxxxxxxxxxxxx","aaaaaaaaaaaaa","0000000000000"));
        data.add(new TransactionRecord("animals", "AnimalMe3","xxxxxxxxxvvvvvvviii","7uiugoag","aigi","guiugh"));

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

         data.add(new TransactionRecord("happy", "FeedMe","candy","Park behind the cub foods","7-9:30 Tuesday Sep. 3","under the tree"));

         return data;
     }
}
