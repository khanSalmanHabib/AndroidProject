package com.gallery.jungle.kalimah;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button kalimahTayyibah = (Button) findViewById(R.id.buttonTayyibah);
        Button kalimahShahadah = (Button) findViewById(R.id.buttonShahadah);
        Button kalimahTamjeed = (Button) findViewById(R.id.buttonTamjeed);
        Button kalimahTawheed = (Button) findViewById(R.id.buttonTawheed);
        Button kalimahIstighfar = (Button) findViewById(R.id.buttonIstighfar);
        Button kalimaRaddeKufr = (Button) findViewById(R.id.buttonRaddeKufr);
        kalimahTayyibah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntentm = new Intent(view.getContext(), KalimahTayyibah.class);
                startActivityForResult(myIntentm, 0);
            }

        });
        kalimahShahadah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntentv = new Intent(view.getContext(), KalimahShahadah.class);
                startActivityForResult(myIntentv, 1);
            }

        });
        kalimahTamjeed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntentp = new Intent(view.getContext(), KalimahTamjeed.class);
                startActivityForResult(myIntentp, 2);
            }

        });
        kalimahTawheed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntentp = new Intent(view.getContext(), KalimahTawheed.class);
                startActivityForResult(myIntentp, 3);
            }

        });
        kalimahIstighfar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntentp = new Intent(view.getContext(), KalimahIstighfar.class);
                startActivityForResult(myIntentp, 4);
            }

        });
        kalimaRaddeKufr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntentp = new Intent(view.getContext(), KalimaRaddeKufr.class);
                startActivityForResult(myIntentp, 5);
            }

        });

    }
}