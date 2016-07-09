package com.gallery.jungle.unique;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleLocationAddress extends AppCompatActivity {

    private static final String TAG_NAME = "Name";
    private static final String TAG_COMPANY = "Company";
    private static final String TAG_LOCATION = "Location";
    private static final String TAG_LOCATION_INFO = "LocationInfo";
    private static final String TAG_ADDRESS = "Address";
    private static final String TAG_COUNTRY_CODE = "CountryCodeNumber";
    private static final String TAG_MOBILE = "MobileNumber";
    private static final String TAG_AREA_CODE = "AreaCodeNumber";
    private static final String TAG_PHONE = "PhoneNumber";


    ArrayList<HashMap<String, String>> counterList, locationCounterList;


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_address);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
    }


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        Intent intent = getIntent();

        String location = intent.getExtras().getString(TAG_LOCATION);

        counterList = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra(TAG_LOCATION_INFO);
        //locationCounterList = new ArrayList<HashMap<String, String>>();

        for (HashMap<String, String> map : counterList) {
            if (map.get(TAG_LOCATION).equals(location)) {
                if (map.get(TAG_COMPANY).equals("Greenline Paribahan")) {
                    List<String> counterInfo = new ArrayList<String>();
                    counterInfo.add(map.get(TAG_ADDRESS));
                    counterInfo.add(map.get(TAG_COUNTRY_CODE) + map.get(TAG_MOBILE));
                    counterInfo.add(map.get(TAG_COUNTRY_CODE) + map.get(TAG_PHONE));


                    listDataHeader.add(map.get(TAG_ADDRESS));
                    listDataChild.put(map.get(TAG_ADDRESS), counterInfo);

                    //locationCounterList.add(map);
                }
            }
        }
    }
}
