package com.ppb.oktavicha.booklabguide.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ppb.oktavicha.booklabguide.R;

public class splash extends AppCompatActivity {
    Thread threadSplash;
    TextView txtTittle;

    private long ms = 0;
    private long splashTime = 3000;
    private boolean splashActive = true;
    private boolean splashPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread th = new Thread() {
            public void run() {
                try {
                    while (splashActive && ms < splashTime) {
                        if
                                (!splashPause) {
                            ms = ms + 100;
                        }
                        sleep(100);
                    }
                } catch (Exception e) {
                    // TODO : handle exception
                } finally {
                    Intent i = new Intent(splash.this, bookform.class);
                    startActivity(i);
                }
            }
        };
        th.start();
    }
}
