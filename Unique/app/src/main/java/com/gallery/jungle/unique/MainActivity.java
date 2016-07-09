package com.gallery.jungle.unique;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ListActivity {

    private ProgressDialog progressDialog;
    private TextView txtPostList;





    private static final String TAG_NAME = "Name";
    private static final String TAG_COMPANY = "Company";
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterList = new ArrayList<HashMap<String, String>>();
        locationList = new ArrayList<HashMap<String, String>>();

        ListView listView = getListView();

        new GetContacts().execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String location = ((TextView) view.findViewById(R.id.location))
                        .getText().toString();
                // Starting single contact activity
                Intent intent = new Intent(getApplicationContext(),
                        SingleLocationAddress.class);
                intent.putExtra(TAG_LOCATION_INFO,   counterList );
                intent.putExtra(TAG_LOCATION, location);

                startActivity(intent);

            }
        });
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("BusCounters.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            // Making a request to url and getting response
            String jsonStr = loadJSONFromAsset();

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    counters = new JSONArray(jsonStr);

                    for (int i = 0; i < counters.length(); i++) {
                        JSONObject counter = counters.getJSONObject(i);

                        String name = counter.getString(TAG_ADDRESS);
                        String company=counter.getString(TAG_COMPANY);
                        String address = counter.getString(TAG_ADDRESS);
                        String location = counter.getString(TAG_LOCATION);
                        String countryCode = counter.getString(TAG_COUNTRY_CODE);
                        String mobile = counter.getString(TAG_MOBILE);
                        String areaCode = counter.getString(TAG_AREA_CODE);
                        String phone = counter.getString(TAG_PHONE);

                        HashMap<String, String> oneCounter = new HashMap<String, String>();
                        HashMap<String, String> oneLocation = new HashMap<String, String>();

                        oneCounter.put(TAG_NAME, name);
                        oneCounter.put(TAG_COMPANY, company);
                        oneCounter.put(TAG_ADDRESS, address);
                        oneCounter.put(TAG_LOCATION, location);
                        oneCounter.put(TAG_COUNTRY_CODE,countryCode);
                        oneCounter.put(TAG_MOBILE, mobile);
                        oneCounter.put(TAG_AREA_CODE,areaCode);
                        oneCounter.put(TAG_PHONE,phone);

                        oneLocation.put(TAG_LOCATION, location);
                        boolean match = false;

                        for (HashMap<String, String> map : locationList)
                            for (Map.Entry<String, String> mapEntry : map.entrySet())
                            {
                                String value = mapEntry.getValue();
                                if (value.equals(location)){
                                    match=true;
                                    break;
                                }
                            }
                        if (match==false)
                        {
                            locationList.add(oneLocation);
                        }

                        counterList.add(oneCounter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (progressDialog.isShowing())
                progressDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, locationList,
                    R.layout.location, new String[] {TAG_LOCATION}, new int[] {R.id.location});

            setListAdapter(adapter);
        }

    }

}
