package com.gallery.jungle.kalimah;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class KalimahTawheed extends Activity {

    private PopupWindow pwindoTranslation;
    private PopupWindow pwindoPronunciation;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalimah_tawheed);

        Button back = (Button) findViewById(R.id.buttonBack);
        Button translation = (Button) findViewById(R.id.buttonTranslation);
        Button pronunciation = (Button) findViewById(R.id.buttonPronunciation);

        back.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intentm = new Intent();
                setResult(RESULT_OK, intentm);
                finish();
            }

        });

        translation.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                initiatePopupWindowTranslation();
            }
        });
        pronunciation.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                initiatePopupWindowPronunciation();
            }
        });
    }

    private void initiatePopupWindowTranslation() {
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) KalimahTawheed.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.screen_popup,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindoTranslation = new PopupWindow(layout, 480, 854, true);
            pwindoTranslation.showAtLocation(layout, Gravity.CENTER, 0, 0);

            TextView tra = (TextView) layout.findViewById(R.id.txtView);
            tra.setText("(There is) no god except Allah - One is He, no partners hath He. His is the Dominion, and His is the Praise. He gives life and causes death, and He is Living, who will not die, never. He of Majesty and Munificence. Within His Hand is (all) good. And He is, upon everything, Able (to exert His Will).");
            Button btnClosePopup = (Button) layout
                    .findViewById(R.id.btn_close_popup);
            btnClosePopup.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    pwindoTranslation.dismiss();
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initiatePopupWindowPronunciation() {
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) KalimahTawheed.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.screen_popup,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindoPronunciation = new PopupWindow(layout, 480, 854, true);
            pwindoPronunciation.showAtLocation(layout, Gravity.CENTER, 0, 0);

            TextView tra = (TextView) layout.findViewById(R.id.txtView);
            tra.setText("lā ilāha illā-llāhu waḥdahu lā sharīka lahu lahu l-mulku wa lahu l-ḥamdu yuḥyi wa yumītu wa huwa ḥayyu lā yamūtu abadan abadan dhu l-jalāli wa l-ʾikrām biyadihi-l khayr wa-huwa ʿala-kulli shayʾin qadīr.");
            Button btnClosePopup = (Button) layout
                    .findViewById(R.id.btn_close_popup);
            btnClosePopup.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    pwindoPronunciation.dismiss();
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}