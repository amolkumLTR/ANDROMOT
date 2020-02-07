package com.ltrsoft.andromot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StatusActivity extends AppCompatActivity {

        Button btnDeviceStatus, btnOnlineStatus;
        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        btnDeviceStatus = (Button) findViewById(R.id.btnDeviceStatus);
        btnOnlineStatus = (Button) findViewById(R.id.btnOnlineStatus);

        btnDeviceStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatusActivity.this, WebView_Activity.class);
                startActivity(intent);
            }
        });
        btnOnlineStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatusActivity.this, WebView_Activity.class);
                startActivity(intent);
            }
        });

        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}