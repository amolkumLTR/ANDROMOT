package com.ltrsoft.andromot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ThresholdActivity extends AppCompatActivity {


    ImageView imageView;
    TextView name, desc, tvThreshold;
    int myImage;
    CheckBox checkBox;
    EditText etThreshold;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threshold);

        imageView = (ImageView) findViewById(R.id.imageview);
        name = (TextView) findViewById(R.id.tvName);
        desc = (TextView) findViewById(R.id.tvDesc);

        tvThreshold = (TextView)findViewById(R.id.tvThreshold);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        btnOk = (Button)findViewById(R.id.btnOk);
        etThreshold = (EditText)findViewById(R.id.etThreshold);

        // to set data
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        desc.setText(intent.getStringExtra("desc"));
        imageView.setImageResource(intent.getIntExtra("image",1));

        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Visible or Envisible checkbox
        etThreshold.setVisibility(View.INVISIBLE);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    etThreshold.setVisibility(View.VISIBLE);
                else
                    etThreshold.setVisibility(View.INVISIBLE);
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ThresholdActivity.this,StatusActivity.class);
                startActivity(intent1);
            }
        });
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
