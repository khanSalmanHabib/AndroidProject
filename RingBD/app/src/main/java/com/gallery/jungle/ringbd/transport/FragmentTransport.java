package com.gallery.jungle.ringbd.transport;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gallery.jungle.ringbd.R;
import com.gallery.jungle.ringbd.transport.bus.BeanPost;
import com.gallery.jungle.ringbd.transport.bus.MainFragmentActivity;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTransport extends Fragment {
    private ProgressDialog progressDialog;
    private TextView txtPostList;
    private ArrayList<BeanPost> beanPostArrayList;




    private static final String TAG_NAME = "Name";
    private static final String TAG_LOCATION = "Location";
    private static final String TAG_LOCATION_INFO = "LocationInfo";
    private static final String TAG_ADDRESS = "Address";
    private static final String TAG_COUNTRY_CODE = "CountryCodeNumber";
    private static final String TAG_MOBILE = "MobileNumber";
    private static final String TAG_AREA_CODE = "AreaCodeNumber";
    private static final String TAG_PHONE = "PhoneNumber";

    // contacts JSONArray
    JSONArray counters = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> counterList,locationList;

    public FragmentTransport() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transports, container, false);


        final Button btnBus = (Button) rootView.findViewById(R.id.btnBus);
        final Button btnTrain = (Button) rootView.findViewById(R.id.btnTrain);
        final Button btnPlane = (Button) rootView.findViewById(R.id.btnPlane);
        final Button btnBoat = (Button) rootView.findViewById(R.id.btnBoat);

        btnBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FragmentTransport.this.getActivity(), MainFragmentActivity.class);
                startActivity(intent);
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }


}
