package com.gallery.jungle.ringbd.transport.bus;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gallery.jungle.ringbd.R;

import java.util.ArrayList;
import java.util.HashMap;


public class SingleCounterInformation extends Activity {

    private static final String TAG_LOCATION = "Location";
    private static final String TAG_LOCATION_INFO = "LocationInfo";
    private static final String TAG_ADDRESS = "Address";
    private static final String TAG_COUNTRY_CODE = "CountryCodeNumber";
    private static final String TAG_MOBILE = "MobileNumber";
    private static final String TAG_AREA_CODE = "AreaCodeNumber";
    private static final String TAG_PHONE = "PhoneNumber";
    ArrayList<HashMap<String, String>> counterList, locationCounterList;

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
        String address = intent.getExtras().getString(TAG_ADDRESS);
        counterList = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra(TAG_LOCATION_INFO);
        locationCounterList = new ArrayList<HashMap<String, String>>();

        String cName = "", cAddress = "", cLocation = "", cCountryCode = "", cMobile = "", cAreaCode = "", cPhone = "";
        for (HashMap<String, String> map : counterList) {
            if (map.get(TAG_ADDRESS).equals(address)) {

                cName = map.get(TAG_ADDRESS);
                cAddress = map.get(TAG_ADDRESS);
                cLocation = map.get(TAG_LOCATION);
                cCountryCode = map.get(TAG_COUNTRY_CODE);
                cMobile = map.get(TAG_MOBILE);
                cAreaCode = map.get(TAG_AREA_CODE);
                cPhone = map.get(TAG_PHONE);
            }
        }
        tViewName.setText(cName);
        tViewAddress.setText(cAddress);
        tViewLocation.setText(cLocation);
        tViewCountryCode.setText(cCountryCode);
        tViewMobile.setText(cMobile);
        tViewAreaCode.setText(cAreaCode);
        tViewPhone.setText(cPhone);
        final String call = cMobile;
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String number = call;
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number));

                if (ActivityCompat.checkSelfPermission(SingleCounterInformation.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(callIntent);
                }

            }

        });



    }


}
