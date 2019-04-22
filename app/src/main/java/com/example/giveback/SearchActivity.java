package com.example.giveback;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchActivity extends AppCompatActivity {

    //
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    //
    private RecyclerView recyclerView;
    private SearchAdapter mAdapter;

    private NavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new NavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_view:
                    startActivity(new Intent(SearchActivity.this, AfterLogin.class));
                    return true;
                case R.id.nav_search_menu:
                    startActivity(new Intent(SearchActivity.this, SearchActivity.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageView noResults = (ImageView) findViewById(R.id.noResults);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search_organizations);

        OrganizationHolderFile.getInstance().resetFilteredOrgData();
        final Intent orgView = new Intent(SearchActivity.this, OrgInfo.class); //this
        recyclerView = (RecyclerView) findViewById(R.id.reclycler);
        mAdapter = new SearchAdapter();
        recyclerView.setAdapter(mAdapter);
        /*recyclerView.addOnItemTouchListener(new RecycleOnClickListener(getBaseContext(), new RecycleOnClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                orgView.putExtra("OrgSelected", OrganizationHolderFile.getInstance().getFilteredOrgData().get(position)); //this
                startActivity(orgView); //this

            }
        }));*/
        NavigationView navigation = findViewById(R.id.navigation);
       // navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
                    //searchOrgList(editText,foundOrg);
                    searchProgramList(editText,foundOrg);
                    filterList(foundOrg,editText,textView);
                }
                return false;
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<OrganizationRecord> foundOrg = new HashSet<>();
                //searchOrgList(editText, foundOrg);
                searchProgramList(editText,foundOrg);
                filterList(foundOrg,editText,view);

            }
        });
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ImageView noResults = (ImageView) findViewById(R.id.noResults);
                noResults.setVisibility(View.GONE);
                OrganizationHolderFile.getInstance().resetFilteredOrgData();
                mAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

    }

    public NavigationView.OnNavigationItemSelectedListener getmOnNavigationItemSelectedListener() {
        return mOnNavigationItemSelectedListener;
    }

    public void setmOnNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener) {
        this.mOnNavigationItemSelectedListener = mOnNavigationItemSelectedListener;
    }

    private void searchProgramList(EditText editText, Set<OrganizationRecord> foundOrg){
        ImageView noResults = (ImageView) findViewById(R.id.noResults);

        noResults.setVisibility(View.GONE);
        String searchText = editText.getText().toString().toLowerCase();
        for (OrganizationRecord organizationRecord:OrganizationHolderFile.getInstance().getOrgData()
        ); //{
            //TODO: fix
         //  for (String program:organizationRecord.getProgramList()){
         //       if (program.toLowerCase().contains(searchText)){
                   // foundOrgadd(organizationRecord);
           //     }
           // }}
    }


    private void searchCollegeList(EditText editText, Set<OrganizationRecord> foundOrg){
        ImageView noResults = (ImageView) findViewById(R.id.noResults);

        noResults.setVisibility(View.GONE);
        String searchText = editText.getText().toString().toLowerCase();
        for (OrganizationRecord organizationRecord:OrganizationHolderFile.getInstance().getOrgData()
        ) {
            if (organizationRecord.getOrgNameOfficial().toLowerCase().contains(searchText)){
                foundOrg.add(organizationRecord);
            }
        }

    }

    private void filterList (Set<OrganizationRecord> foundOrg, EditText editText, View view){
        List<OrganizationRecord> list = new ArrayList<OrganizationRecord>(foundOrg);
        OrganizationHolderFile.getInstance().setFilteredOrgData(list);
        mAdapter.notifyDataSetChanged();
        editText.clearFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }
}
