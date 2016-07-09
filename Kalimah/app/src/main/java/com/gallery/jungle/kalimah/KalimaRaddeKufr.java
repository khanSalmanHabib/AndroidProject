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

public class KalimaRaddeKufr extends Activity {

    private PopupWindow pwindoTranslation;
    private PopupWindow pwindoPronunciation;

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalima_radde_kufr);

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
            LayoutInflater inflater = (LayoutInflater) KalimaRaddeKufr.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.screen_popup,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindoTranslation = new PopupWindow(layout, 480, 854, true);
            pwindoTranslation.showAtLocation(layout, Gravity.CENTER, 0, 0);

            TextView tra = (TextView) layout.findViewById(R.id.txtView);
            tra.setText("O Allah! I seek protection in You from that I should not join any partner with You and I have knowledge of it. I seek Your forgiveness from that which I do not know. I repent from it (ignorance) and I reject disbelief and joining partners with You and of falsehood and slandering and innovation in religion and tell-tales and evil deeds and the blame and the disobedience, all of them. I submit to Your will and I believe and I declare: There is none worthy of worship except Allah and Muhammad is His Messenger.");
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
            LayoutInflater inflater = (LayoutInflater) KalimaRaddeKufr.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.screen_popup,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindoPronunciation = new PopupWindow(layout, 480, 854, true);
            pwindoPronunciation.showAtLocation(layout, Gravity.CENTER, 0, 0);

            TextView tra = (TextView) layout.findViewById(R.id.txtView);
            tra.setText("Allāhumma innī aʿūḏu bika min an ušrika bika šayʾaw-wwa-anā aʿlamu bihi wa-staġfiruka limā lā aʿlamu bihi tubtu ʿanhu wa tabarra'tu mina-l-kufri wa-š-širki wa-l-kiḏhbi wa-l-ġībati wa-l-bidʿati wa-nnamīmati wa-l-fawāḥiši wa-l-buhtāni wa-l-maʿāṣī kullihā wa aslamtu wa aqūlu lā ilāha illā-llāhu Muḥammadu-r-rasūlu llāh.");
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
