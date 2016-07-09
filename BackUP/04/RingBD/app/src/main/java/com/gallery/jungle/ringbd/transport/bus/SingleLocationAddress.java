package com.gallery.jungle.ringbd.transport.bus;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.gallery.jungle.ringbd.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SingleLocationAddress extends ListActivity {
    private static final String TAG_NAME = "Name";
    private static final String TAG_LOCATION = "Location";
    private static final String TAG_LOCATION_INFO = "LocationInfo";
    private static final String TAG_ADDRESS = "Address";
    private static final String TAG_COUNTRY_CODE = "CountryCodeNumber";
    private static final String TAG_MOBILE = "MobileNumber";
    private static final String TAG_AREA_CODE = "AreaCodeNumber";
    private static final String TAG_PHONE = "PhoneNumber";

    ArrayList<HashMap<String, String>> counterList,locationCounterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_address);
        ListView listView = getListView();
        Intent intent = getIntent();

        String location = intent.getExtras().getString(TAG_LOCATION);

        counterList = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra(TAG_LOCATION_INFO);
        locationCounterList = new ArrayList<HashMap<String, String>>();

        for (HashMap<String, String> map : counterList)
        {
            if (map.get(TAG_LOCATION).equals(location)){
                locationCounterList.add(map);
            }
        }

        ListAdapter adapter = new SimpleAdapter(
                SingleLocationAddress.this, locationCounterList,
                R.layout.address, new String[] {TAG_ADDRESS,TAG_LOCATION}, new int[] { R.id.name,R.id.address});

        setListAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String address = ((TextView) view.findViewById(R.id.name))
                        .getText().toString();
                // Starting single contact activity
                Intent intent = new Intent(getApplicationContext(),
                        SingleCounterInformation.class);
                intent.putExtra(TAG_LOCATION_INFO,locationCounterList);
                intent.putExtra(TAG_ADDRESS, address);

                startActivity(intent);

            }
        });



/*
        ListView listView = getListView();

        ListAdapter adapter = new SimpleAdapter(
                this, counterList,
                R.layout.address, new String[] { TAG_NAME, TAG_ADDRESS,
                TAG_LOCATION,TAG_COUNTRY_CODE,TAG_MOBILE,TAG_AREA_CODE,TAG_PHONE }, new int[] { R.id.name,
                R.id.address, R.id.location,R.id.countryCode,R.id.mobile,R.id.areaCode,R.id.phone });
        setListAdapter(adapter);
*/

    }
}
/*

        TextView tViewName = (TextView) findViewById(R.id.sName);
        TextView tViewAddress = (TextView) findViewById(R.id.sAddress);
        TextView tViewLocation = (TextView) findViewById(R.id.sLocation);
        TextView tViewCountryCode = (TextView) findViewById(R.id.sCountryCode);
        TextView tViewMobile = (TextView) findViewById(R.id.sMobile);
        TextView tViewAreaCode = (TextView) findViewById(R.id.sAreaCode);
        TextView tViewPhone = (TextView) findViewById(R.id.sPhone);

        String name = intent.getStringExtra(TAG_ADDRESS);
        String address = intent.getStringExtra(TAG_ADDRESS);
        String location = intent.getStringExtra(TAG_LOCATION);
        String countryCode = intent.getStringExtra(TAG_COUNTRY_CODE);
        String mobile = intent.getStringExtra(TAG_MOBILE);
        String areaCode = intent.getStringExtra(TAG_AREA_CODE);
        String phone = intent.getStringExtra(TAG_PHONE);

        tViewName.setText(name);
        tViewAddress.setText(address);
        tViewLocation.setText(location);
        tViewCountryCode.setText(countryCode);
        tViewMobile.setText(mobile);
        tViewAreaCode.setText(areaCode);
        tViewPhone.setText(phone);


        */