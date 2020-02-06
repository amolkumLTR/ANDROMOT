package com.ltrsoft.andromot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1000);

                    Intent main_activity_intent=new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(main_activity_intent);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
