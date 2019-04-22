/*package com.example.giveback;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.giveback.AfterLogin;
import com.example.giveback.OrgInfo;
import com.example.giveback.OrganizationHolderFile;
import com.example.giveback.OrganizationRecord;
import com.example.giveback.R;
import com.example.giveback.SearchAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.support.v4.content.ContextCompat.startActivity;

public class SearchOrganizations extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    //
    private RecyclerView mRecycler;
    private SearchAdapter mAdapter;

    private NavigationView.OnClickListener mOnClickListener;



    //TODO: fix needs most work here

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //ImageView noResults = (ImageView) findViewById(R.id.noResults);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search_organizations);

        OrganizationHolderFile.getInstance().resetFilteredOrgData();
        final Intent orgView = new Intent(SearchOrganizations.this, OrgInfo.class); //this
        mRecycler = (RecyclerView) findViewById(R.id.reclycler);
        mAdapter = new SearchAdapter();
        mRecycler.setAdapter(mAdapter);


        mRecycler.addOnItemTouchListener(new RecyclerView.OnItemTouchListener(getBaseContext(), new RecycleOnClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //orgView.putExtra("OrgSelected", OrganizationHolderFile.getInstance().getFilteredOrgData().get(position));
                startActivity(orgView);

            }
        }));
//        {
//            @Override
//            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean b) {
//
//            }
//        });
        //DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.nav_donor_menu);

        NavigationView navigation = findViewById(R.id.nav_donor_menu);
        navigation.setOnClickListener(mOnClickListener);
        Menu a = navigation.getMenu();
        MenuItem b = a.findItem(R.id.nav_search_menu);
        b.setChecked(true);
        Button searchButton = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editSearch);
        Button clearButton = findViewById(R.id.clear);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode()==KeyEvent.KEYCODE_ENTER){
                    Set<OrganizationRecord> foundOrg = new HashSet<>();
                    searchOrgList(editText,foundOrg);
                    //searchProgramList(editText,foundOrg);
                    filterList(foundOrg,editText,textView);
                }
                return false;
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<OrganizationRecord> foundOrg = new HashSet<>();
                searchOrgList(editText, foundOrg);
                //searchProgramList(editText,foundOrg);
                filterList(foundOrg,editText,view);

            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView noResults = (ImageView) findViewById(R.id.noResults);

                noResults.setVisibility(View.GONE);
                OrganizationHolderFile.getInstance().resetFilteredOrgData();
                mAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

    }
    private void searchOrgList(EditText editText, Set<OrganizationRecord> foundOrg) {
        ImageView noResults = (ImageView) findViewById(R.id.noResults);

        noResults.setVisibility(View.GONE);
        String searchText = editText.getText().toString().toLowerCase();
        for (OrganizationRecord organizationRecord : OrganizationHolderFile.getInstance().getOrgData()
        ) {
            if (organizationRecord.getOrgNameOfficial().toLowerCase().contains(searchText)) {
                foundOrg.add(organizationRecord);
            }
        }

    }

    public interface RecycleOnClickListener { }

    private void filterList (Set<OrganizationRecord> foundOrg, EditText editText, View view){
        List<OrganizationRecord> list = new ArrayList<OrganizationRecord>(foundOrg);
        OrganizationHolderFile.getInstance().setFilteredOrgData(list);
        mAdapter.notifyDataSetChanged();
        editText.clearFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    public Object getSystemService(String inputMethodService) { return inputMethodService; }

    public String findViewById(String findViewById) { return findViewById; }

    private class OnItemClickListener { }
}*/
