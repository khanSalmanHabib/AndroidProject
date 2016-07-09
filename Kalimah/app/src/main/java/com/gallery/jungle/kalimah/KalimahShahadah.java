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

public class KalimahShahadah extends Activity {

    private PopupWindow pwindoTranslation;
    private PopupWindow pwindoPronunciation;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalimah_shahadah);

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
            LayoutInflater inflater = (LayoutInflater) KalimahShahadah.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.screen_popup,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindoTranslation = new PopupWindow(layout, 480, 854, true);
            pwindoTranslation.showAtLocation(layout, Gravity.CENTER, 0, 0);

            TextView tra = (TextView) layout.findViewById(R.id.txtView);
            tra.setText("I bear witness that (there is) no god except Allah; One is He, no partner hath He, and I bear witness that Muhammad is His Servant and Messenger.");
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
            LayoutInflater inflater = (LayoutInflater) KalimahShahadah.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.screen_popup,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindoPronunciation = new PopupWindow(layout, 480, 854, true);
            pwindoPronunciation.showAtLocation(layout, Gravity.CENTER, 0, 0);

            TextView tra = (TextView) layout.findViewById(R.id.txtView);
            tra.setText("Ašhadu an lā ilāha illā-llāh waḥdahu lā šarīka lahu, wa ašhadu anna muḥammadan ʿabduhu wa rasūluhu.");
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