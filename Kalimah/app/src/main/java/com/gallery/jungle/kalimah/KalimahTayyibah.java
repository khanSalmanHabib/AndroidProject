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

public class KalimahTayyibah extends Activity {

    private PopupWindow pwindoTranslation;
    private PopupWindow pwindoPronunciation;

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalimah_tayyibah);

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
            LayoutInflater inflater = (LayoutInflater) KalimahTayyibah.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.screen_popup,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindoTranslation = new PopupWindow(layout, 480, 854, true);
            pwindoTranslation.showAtLocation(layout, Gravity.CENTER, 0, 0);

            TextView tra = (TextView) layout.findViewById(R.id.txtView);
            tra.setText("There is no god but Allah, [and] Muhammad is the messenger of Allah.");
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
            LayoutInflater inflater = (LayoutInflater) KalimahTayyibah.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.screen_popup,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindoPronunciation = new PopupWindow(layout, 480, 854, true);
            pwindoPronunciation.showAtLocation(layout, Gravity.CENTER, 0, 0);

            TextView tra = (TextView) layout.findViewById(R.id.txtView);
            tra.setText("'lā ilāha illā -llāh, muḥammadur rasūlu -llāh.");
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