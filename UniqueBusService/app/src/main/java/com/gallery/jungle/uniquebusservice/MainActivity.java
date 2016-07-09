package com.gallery.jungle.uniquebusservice;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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


public class MainActivity extends ListActivity {

    private ProgressDialog progressDialog;
    private static final String TAG_NAME = "Name";
    private static final String TAG_LOCATION = "Location";
    private static final String TAG_ADDRESS = "Address";
    private static final String TAG_COUNTRY_CODE = "CountryCodeNumber";
    private static final String TAG_MOBILE = "MobileNumber";
    private static final String TAG_AREA_CODE = "AreaCodeNumber";
    private static final String TAG_PHONE = "PhoneNumber";
    JSONArray counters = null;
    private Counter oneCounter;

    private ArrayList<String> location =new ArrayList<String>();
    ArrayList<Counter> counterList,singleLocationCounterList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterList = new ArrayList<Counter>();

        new GetContacts().execute();

        CounterAdapter adapter = new CounterAdapter(this,counterList);
        ListView listView = (ListView) findViewById(R.id.list_loca);
        listView.setAdapter(adapter);





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem

                String name = ((TextView) view.findViewById(R.id.name))
                        .getText().toString();

                // Starting single contact activity
                Intent intent = new Intent(getApplicationContext(),
                        SingleLocationInformation.class);
                intent.putExtra(TAG_NAME, name);

                startActivity(intent);

            }
        });
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

            if (jsonStr != null) {
                try {
                    counters = new JSONArray(jsonStr);

                    // looping through All Contacts

                    for (int i = 0; i < counters.length(); i++) {
                        JSONObject counter = counters.getJSONObject(i);
                        oneCounter.setId(i);
                        oneCounter.setName(counter.getString(TAG_ADDRESS));
                        oneCounter.setAddress(counter.getString(TAG_ADDRESS));
                        oneCounter.setLocation(counter.getString(TAG_LOCATION));
                        oneCounter.setCountryCodeNumber(counter.getString(TAG_COUNTRY_CODE));
                        oneCounter.setMobileNumber(counter.getString(TAG_MOBILE));
                        oneCounter.setAreaCodeNumber(counter.getString(TAG_AREA_CODE));
                        oneCounter.setPhoneNumber(counter.getString(TAG_PHONE));
                        location.add(i,counter.getString(TAG_ADDRESS));



                        // adding contact to contact list
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


        }

    }

 /*   public ArrayList<HashMap<String, String>> SingleLocationCounterInfo(){

        singleLocationCounterList = new ArrayList<HashMap<String, String>>();

        if (counterList != null) {

            for (int i = 0; i < counterList.size(); i++) {
                HashMap<String, String> oneCounter = new HashMap< String,String >();
                oneCounter=counterList.get(i);
                location.add(oneCounter.containsKey(""));


            }
        }

        return singleLocationCounterList;
    }
*/
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

}
/*

        txtPostList=(TextView)findViewById(R.id.txtPostList);
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                Type listType = new TypeToken<ArrayList<Counter>>(){}.getType();
                beanPostArrayList = new GsonBuilder().create().fromJson(loadJSONFromAsset(), listType);
                postList=new StringBuffer();
                for(Counter post: beanPostArrayList){
                    postList.append("\n Location: "+post.getLocation()+"\n Address: "+post.getAddress()+"\n CountryCodeNumber: "+post.getCountryCodeNumber()+"\n MobileNumber: "+post.getMobileNumber()+"\n AreaCodeNumber: "+post.getAreaCodeNumber()+"\n PhoneNumber: "+post.getPhoneNumber()+"\n\n");
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                progressDialog.dismiss();
                txtPostList.setText(postList);

            }
        }.execute();






          String address = ((TextView) view.findViewById(R.id.address))
                        .getText().toString();
                String location = ((TextView) view.findViewById(R.id.location))
                        .getText().toString();
                String countryCode = ((TextView) view.findViewById(R.id.countryCode))
                        .getText().toString();

                String mobile = ((TextView) view.findViewById(R.id.mobile))
                        .getText().toString();

                String areaCode = ((TextView) view.findViewById(R.id.areaCode))
                        .getText().toString();

                String phone = ((TextView) view.findViewById(R.id.phone))
                        .getText().toString();



                intent.putExtra(TAG_LOCATION, location);
                intent.putExtra(TAG_COUNTRY_CODE, countryCode);
                intent.putExtra(TAG_MOBILE, mobile);
                intent.putExtra(TAG_AREA_CODE, areaCode);
                intent.putExtra(TAG_PHONE, phone);

    private ArrayList<Counter> beanPostArrayList;

*/


