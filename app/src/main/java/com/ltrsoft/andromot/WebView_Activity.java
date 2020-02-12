package com.ltrsoft.andromot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebView_Activity extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_);

        progressBar =(ProgressBar)findViewById(R.id.progressbar);
        WebView mywebview = (WebView) findViewById(R.id.webView);

        Intent intent = getIntent();
        String website = intent.getStringExtra("Links");

        mywebview.getSettings().setJavaScriptEnabled(true);
        WebSettings webSettings = mywebview.getSettings();
        mywebview.getSettings().setSupportZoom(false);
        mywebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mywebview.getSettings().setBuiltInZoomControls(false);

        mywebview.setWebViewClient(new WebViewClient());
        mywebview.loadUrl(website);

        mywebview.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);

                if(newProgress==100)
                    progressBar.setVisibility(View.GONE);
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });


        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
