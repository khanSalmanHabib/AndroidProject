package com.gallery.jungle.uniquebusservice;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;



public class SingleCounterInformation extends Activity {

    private static final String TAG_LOCATION = "Location";
    private static final String TAG_ADDRESS = "Address";
    private static final String TAG_COUNTRY_CODE = "CountryCodeNumber";
    private static final String TAG_MOBILE = "MobileNumber";
    private static final String TAG_AREA_CODE = "AreaCodeNumber";
    private static final String TAG_PHONE = "PhoneNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_counter);

        TextView tViewName = (TextView) findViewById(R.id.sName);
        TextView tViewAddress = (TextView) findViewById(R.id.sAddress);
        TextView tViewLocation = (TextView) findViewById(R.id.sLocation);
        TextView tViewCountryCode = (TextView) findViewById(R.id.sCountryCode);
        TextView tViewMobile = (TextView) findViewById(R.id.sMobile);
        TextView tViewAreaCode = (TextView) findViewById(R.id.sAreaCode);
        TextView tViewPhone = (TextView) findViewById(R.id.sPhone);

        Intent intent = getIntent();

        // getting attached intent data

        String name = intent.getStringExtra(TAG_ADDRESS);
        String address = intent.getStringExtra(TAG_ADDRESS);
        String location = intent.getStringExtra(TAG_LOCATION);
        String countryCode = intent.getStringExtra(TAG_COUNTRY_CODE);
        String mobile = intent.getStringExtra(TAG_MOBILE);
        String areaCode = intent.getStringExtra(TAG_AREA_CODE);
        String phone = intent.getStringExtra(TAG_PHONE);

        // displaying selected product name

        tViewName.setText(name);
        tViewAddress.setText(address);
        tViewLocation.setText(location);
        tViewCountryCode.setText(countryCode);
        tViewMobile.setText(mobile);
        tViewAreaCode.setText(areaCode);
        tViewPhone.setText(phone);



    }


}
