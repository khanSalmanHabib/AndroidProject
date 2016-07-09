package com.gallery.jungle.kalimah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Open extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent open = new Intent("com.gallery.jungle.kalimah.MainActivity");
                    startActivity(open);
                }
            }

        };
        timer.start();


    }
}