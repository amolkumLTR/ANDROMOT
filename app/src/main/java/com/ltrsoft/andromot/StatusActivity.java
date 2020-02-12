package com.ltrsoft.andromot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StatusActivity extends AppCompatActivity {
        WifiManager wifiManager;
        String[] urls =new String[2];
        Button btnDeviceStatus, btnOnlineStatus;
        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        btnDeviceStatus = (Button) findViewById(R.id.btnDeviceStatus);
        btnOnlineStatus = (Button) findViewById(R.id.btnOnlineStatus);

        urls[0]="http://192.168.4.1";
        urls[1]="https://ltr-soft.com/temp/show.php";


            btnDeviceStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                if (wifiManager.isWifiEnabled()) {

                    Intent intent = new Intent(StatusActivity.this, WebView_Activity.class);
                    intent.putExtra("Links", urls[0]);
                    startActivity(intent);
                }
                if(!wifiManager.isWifiEnabled())
                {
                    openDialog();
                }
            }
        });
        btnOnlineStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StatusActivity.this,WebView_Activity.class);
                intent.putExtra("Links", urls[1]);
                startActivity(intent);
            }
        });

        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    //To create Dialog Box
    public void openDialog()
    {
        DialogExample dialogExample = new DialogExample();
        dialogExample.show(getSupportFragmentManager(),"dialog example");
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