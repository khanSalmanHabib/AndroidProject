package com.gallery.jungle.uniquebusservice;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class SingleLocationInformation extends ListActivity {
    private static final String TAG_NAME = "Name";
    private static final String TAG_LOCATION = "Location";
    private static final String TAG_ADDRESS = "Address";
    private static final String TAG_COUNTRY_CODE = "CountryCodeNumber";
    private static final String TAG_MOBILE = "MobileNumber";
    private static final String TAG_AREA_CODE = "AreaCodeNumber";
    private static final String TAG_PHONE = "PhoneNumber";

    ArrayList<HashMap<String, String>> counterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.list_address);

        Intent intent = getIntent();

/*
        ListView listView = getListView();

        ListAdapter adapter = new SimpleAdapter(
                this, counterList,
                R.layout.list_address, new String[] { TAG_NAME, TAG_ADDRESS,
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