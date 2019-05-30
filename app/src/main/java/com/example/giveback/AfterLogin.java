 package com.example.giveback;

import android.Manifest;
import android.accounts.AccountManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.GooglePlayServicesAvailabilityIOException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;

import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;

import com.example.giveback.fragments.DonationRequestFragment;
import com.example.giveback.fragments.LoginFragment;
import com.example.giveback.fragments.OrganizationRecyclerFragment;
import com.example.giveback.fragments.TransactionRecyclerFragment;
import com.example.giveback.fragments.DonorRecyclerFragment;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

 public class AfterLogin extends AppCompatActivity {

     private Boolean userType;
     private Toolbar toolbar;
     private DrawerLayout drawer;
     private NavigationView navigationView;
     private CalendarView mCalendarView;
     GoogleAccountCredential mCredential;

     static final int REQUEST_ACCOUNT_PICKER = 1000;
     static final int REQUEST_AUTHORIZATION = 1001;
     static final int REQUEST_GOOGLE_PLAY_SERVICES = 1002;
     static final int REQUEST_PERMISSION_GET_ACCOUNTS = 1003;

     private static final String PREF_ACCOUNT_NAME = "accountName";
     // TODO: Find out what accountName really is
     private static final String[] SCOPES = { SheetsScopes.SPREADSHEETS_READONLY };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get bundle and userType from MainActivity
        Bundle bundle = getIntent().getExtras();
        userType = bundle.getBoolean("userType");
        String whereToGo = bundle.getString("whereToGo");


        if(userType)
        {
            setContentView(R.layout.activity_main_donor);
            //creating fragment object
            Fragment fragment = null;
            if(whereToGo == null) {
                fragment = new DonorRecyclerFragment();
                ((DonorRecyclerFragment) fragment).setDonorRecords(getDonorRecords());
                ((DonorRecyclerFragment) fragment).setTitle("My Information");
            }else if(whereToGo.equals("pendCon")){
                fragment = new TransactionRecyclerFragment();
                ((TransactionRecyclerFragment) fragment).setData(getPendingConfirmations());
                ((TransactionRecyclerFragment) fragment).setTitle("Pending Confirmation");
                ((TransactionRecyclerFragment) fragment).setDonor(userType);
            }

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


        mCredential = GoogleAccountCredential.usingOAuth2(
                getApplicationContext(), Arrays.asList(SCOPES))
                .setBackOff(new ExponentialBackOff());
        getResultsFromApi();
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

        data.add(new TransactionRecord("Non-Perishable food", "Are You Hungry"," non-perishable goods, 4 jars of peanut butter","123 Baker Street, Eagan, MN","4:30 pm May 2nd","none"));
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

         data.add(new TransactionRecord("Non-Perishable food", "Are You Hungry"," non-perishable goods, 4 jars of peanut butter","123 Baker Street, Eagan, MN","4:30 pm May 2nd","none"));
         data.add(new TransactionRecord("Clothes", "Are You Hungry","47 t-shirts","6832 Brookstone Bridge, Mpls 55683","7-9:30pm Tuesday Sep. 3","On my porch step"));

         return data;
     }

     /**
      * Get the pending confirmations for the current organization (currently hardcoded)
      * TODO: have it take in an org Name and only return those items.
      * @return
      */
     private ArrayList<TransactionRecord> getPickupHistoryRecords() {
         ArrayList<TransactionRecord> data = new ArrayList<>();

         data.add(new TransactionRecord("Non-Perishable food", "Are You Hungry"," non-perishable goods, 4 jars of peanut butter","123 Baker Street, Eagan, MN","4:30 pm May 2nd","none"));
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
//     public class CalendarActivity extends AppCompatActivity {
//
//         private  static final String TAG = "CalendarActivity";
//         private CalendarView mCalendarView;
//         @Override
//         protected void onCreate(@Nullable Bundle savedInstanceState) {
//             super.onCreate(savedInstanceState);
//             setContentView(R.layout.donation_request);
//             mCalendarView = (CalendarView) findViewById(R.id.calendarView);
//             mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//                 @Override
//                 public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
//                     String date = year + "/" + month + "/"+ dayOfMonth ;
//                     Log.d(TAG, "onSelectedDayChange: yyyy/mm/dd:" + date);
//                     Intent intent = new Intent(CalendarActivity.this,MainActivity.class);
//                     intent.putExtra("date",date);
//                     startActivity(intent);
//
//                 }
//             });
//         }
//     }

     private void getResultsFromApi() {
         Toast.makeText(getApplicationContext(), "starting getResultsFromAPi", Toast.LENGTH_SHORT).show();
         System.out.println("boourns");
         if (! isGooglePlayServicesAvailable()) {
             acquireGooglePlayServices();
         } else if (mCredential.getSelectedAccountName() == null) {
             chooseAccount();
         } else if (! isDeviceOnline()) {
             Toast.makeText(getApplicationContext(), "No network connection available.", Toast.LENGTH_SHORT).show();
             //mOutputText.setText("No network connection available.");
         } else {
             new MakeRequestTask(mCredential).execute();
         }
     }

     /**
      * Attempts to set the account used with the API credentials. If an account
      * name was previously saved it will use that one; otherwise an account
      * picker dialog will be shown to the user. Note that the setting the
      * account to use with the credentials object requires the app to have the
      * GET_ACCOUNTS permission, which is requested here if it is not already
      * present. The AfterPermissionGranted annotation indicates that this
      * function will be rerun automatically whenever the GET_ACCOUNTS permission
      * is granted.
      */
     @AfterPermissionGranted(REQUEST_PERMISSION_GET_ACCOUNTS)
     private void chooseAccount() {
         if (EasyPermissions.hasPermissions(
                 this, Manifest.permission.GET_ACCOUNTS)) {
             String accountName = getPreferences(Context.MODE_PRIVATE)
                     .getString(PREF_ACCOUNT_NAME, null);
             if (accountName != null) {
                 mCredential.setSelectedAccountName(accountName);
                 getResultsFromApi();
             } else {
                 // Start a dialog from which the user can choose an account
                 startActivityForResult(
                         mCredential.newChooseAccountIntent(),
                         REQUEST_ACCOUNT_PICKER);
             }
         } else {
             // Request the GET_ACCOUNTS permission via a user dialog
             EasyPermissions.requestPermissions(
                     this,
                     "This app needs to access your Google account (via Contacts).",
                     REQUEST_PERMISSION_GET_ACCOUNTS,
                     Manifest.permission.GET_ACCOUNTS);
         }
     }

     /**
      * Called when an activity launched here (specifically, AccountPicker
      * and authorization) exits, giving you the requestCode you started it with,
      * the resultCode it returned, and any additional data from it.
      * @param requestCode code indicating which activity result is incoming.
      * @param resultCode code indicating the result of the incoming
      *     activity result.
      * @param data Intent (containing result data) returned by incoming
      *     activity result.
      */
     @Override
     protected void onActivityResult(
             int requestCode, int resultCode, Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         switch(requestCode) {
             case REQUEST_GOOGLE_PLAY_SERVICES:
                 if (resultCode != RESULT_OK) {
                     Toast.makeText(getApplicationContext(), "This app requires Google Play Services.", Toast.LENGTH_SHORT).show();
                     //mOutputText.setText(
                       //      "This app requires Google Play Services. Please install " +
                         //            "Google Play Services on your device and relaunch this app.");
                 } else {
                     getResultsFromApi();
                 }
                 break;
             case REQUEST_ACCOUNT_PICKER:
                 if (resultCode == RESULT_OK && data != null &&
                         data.getExtras() != null) {
                     String accountName =
                             data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                     if (accountName != null) {
                         SharedPreferences settings =
                                 getPreferences(Context.MODE_PRIVATE);
                         SharedPreferences.Editor editor = settings.edit();
                         editor.putString(PREF_ACCOUNT_NAME, accountName);
                         editor.apply();
                         mCredential.setSelectedAccountName(accountName);
                         getResultsFromApi();
                     }
                 }
                 break;
             case REQUEST_AUTHORIZATION:
                 if (resultCode == RESULT_OK) {
                     getResultsFromApi();
                 }
                 break;
         }
     }

     /**
      * Respond to requests for permissions at runtime for API 23 and above.
      * @param requestCode The request code passed in
      *     requestPermissions(android.app.Activity, String, int, String[])
      * @param permissions The requested permissions. Never null.
      * @param grantResults The grant results for the corresponding permissions
      *     which is either PERMISSION_GRANTED or PERMISSION_DENIED. Never null.
      */
     @Override
     public void onRequestPermissionsResult(int requestCode,
                                            @NonNull String[] permissions,
                                            @NonNull int[] grantResults) {
         super.onRequestPermissionsResult(requestCode, permissions, grantResults);
         EasyPermissions.onRequestPermissionsResult(
                 requestCode, permissions, grantResults, this);
     }

     /**
      * Callback for when a permission is granted using the EasyPermissions
      * library.
      * @param requestCode The request code associated with the requested
      *         permission
      * @param list The requested permission list. Never null.
      */
//     @Override
//     public void onPermissionsGranted(int requestCode, List<String> list) {
//         // Do nothing.
//     }

     /**
      * Callback for when a permission is denied using the EasyPermissions
      * library.
      * @param requestCode The request code associated with the requested
      *         permission
      * @param list The requested permission list. Never null.
      */
//     @Override
//     public void onPermissionsDenied(int requestCode, List<String> list) {
//         // Do nothing.
//     }

     /**
      * Checks whether the device currently has a network connection.
      * @return true if the device has a network connection, false otherwise.
      */
     private boolean isDeviceOnline() {
         ConnectivityManager connMgr =
                 (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
         return (networkInfo != null && networkInfo.isConnected());
     }

     /**
      * Check that Google Play services APK is installed and up to date.
      * @return true if Google Play Services is available and up to
      *     date on this device; false otherwise.
      */
     private boolean isGooglePlayServicesAvailable() {
         GoogleApiAvailability apiAvailability =
                 GoogleApiAvailability.getInstance();
         final int connectionStatusCode =
                 apiAvailability.isGooglePlayServicesAvailable(this);
         return connectionStatusCode == ConnectionResult.SUCCESS;
     }

     /**
      * Attempt to resolve a missing, out-of-date, invalid or disabled Google
      * Play Services installation via a user dialog, if possible.
      */
     private void acquireGooglePlayServices() {
         GoogleApiAvailability apiAvailability =
                 GoogleApiAvailability.getInstance();
         final int connectionStatusCode =
                 apiAvailability.isGooglePlayServicesAvailable(this);
         if (apiAvailability.isUserResolvableError(connectionStatusCode)) {
             showGooglePlayServicesAvailabilityErrorDialog(connectionStatusCode);
         }
     }


     /**
      * Display an error dialog showing that Google Play Services is missing
      * or out of date.
      * @param connectionStatusCode code describing the presence (or lack of)
      *     Google Play Services on this device.
      */
     void showGooglePlayServicesAvailabilityErrorDialog(
             final int connectionStatusCode) {
         GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
         Dialog dialog = apiAvailability.getErrorDialog(
                 AfterLogin.this,
                 connectionStatusCode,
                 REQUEST_GOOGLE_PLAY_SERVICES);
         dialog.show();
     }

     /**
      * An asynchronous task that handles the Google Sheets API call.
      * Placing the API calls in their own task ensures the UI stays responsive.
      */
     private class MakeRequestTask extends AsyncTask<Void, Void, List<String>> {
         private com.google.api.services.sheets.v4.Sheets mService = null;
         private Exception mLastError = null;

         MakeRequestTask(GoogleAccountCredential credential) {
             HttpTransport transport = AndroidHttp.newCompatibleTransport();
             JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
             mService = new com.google.api.services.sheets.v4.Sheets.Builder(
                     transport, jsonFactory, credential)
                     .setApplicationName("Google Sheets API Android Quickstart")
                     .build();
         }

         /**
          * Background task to call Google Sheets API.
          * @param params no parameters needed for this task.
          */
         @Override
         protected List<String> doInBackground(Void... params) {
             try {
                 return getDataFromApi();
             } catch (Exception e) {
                 mLastError = e;
                 cancel(true);
                 return null;
             }
         }

         /**
          * Fetch a list of names and majors of students in a sample spreadsheet:
          * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
          * @return List of names and majors
          * @throws IOException
          */
         private List<String> getDataFromApi() throws IOException {
             String spreadsheetId = "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
             String range = "Class Data!A2:E";
             List<String> results = new ArrayList<String>();
             ValueRange response = this.mService.spreadsheets().values()
                     .get(spreadsheetId, range)
                     .execute();
             List<List<Object>> values = response.getValues();
             if (values != null) {
                 results.add("Name, Major");
                 for (List row : values) {
                     results.add(row.get(0) + ", " + row.get(4));
                 }
             }
             return results;
         }



         @Override
         protected void onPreExecute() {
//             mOutputText.setText("");
//             mProgress.show();
         }

         @Override
         protected void onPostExecute(List<String> output) {
//             mProgress.hide();
             if (output == null || output.size() == 0) {
                 Toast.makeText(getApplicationContext(), "No results returned.", Toast.LENGTH_SHORT).show();
                 //mOutputText.setText("No results returned.");
             } else {
                 output.add(0, "Data retrieved using the Google Sheets API:");
                // mOutputText.setText(TextUtils.join("\n", output));
                 Toast.makeText(getApplicationContext(), TextUtils.join("\n", output), Toast.LENGTH_SHORT).show();
             }
         }

         @Override
         protected void onCancelled() {
             //mProgress.hide();
             if (mLastError != null) {
                 if (mLastError instanceof GooglePlayServicesAvailabilityIOException) {
                     showGooglePlayServicesAvailabilityErrorDialog(
                             ((GooglePlayServicesAvailabilityIOException) mLastError)
                                     .getConnectionStatusCode());
                 } else if (mLastError instanceof UserRecoverableAuthIOException) {
                     startActivityForResult(
                             ((UserRecoverableAuthIOException) mLastError).getIntent(),
                             AfterLogin.REQUEST_AUTHORIZATION);
                 } else {
                     Toast.makeText(getApplicationContext(), "The following error occurred:\n"
                             + mLastError.getMessage(), Toast.LENGTH_SHORT).show();
//                     mOutputText.setText("The following error occurred:\n"
//                             + mLastError.getMessage());
                 }
             } else {
                 Toast.makeText(getApplicationContext(), "Request cancelled.", Toast.LENGTH_SHORT).show();
                 //mOutputText.setText("Request cancelled.");
             }
         }
     }
 }
