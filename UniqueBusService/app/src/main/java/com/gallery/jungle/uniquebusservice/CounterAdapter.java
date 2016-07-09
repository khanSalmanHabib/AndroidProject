package com.gallery.jungle.uniquebusservice;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Salman on 4/28/2016.
 */
public class CounterAdapter extends ArrayAdapter<Counter> {
    public CounterAdapter(Context context, ArrayList<Counter> counters) {
        super(context,R.layout.list_location,counters);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Counter counter = getItem(position);
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        convertView = layoutInflater.inflate(R.layout.list_location,parent,false);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.name);
        nameTextView.setText(counter.getName());
        return convertView;

    }
}
