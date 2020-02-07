package com.ltrsoft.andromot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Listview

    ListView list;
    String name[] = {"Sugarcane","Banana","Sunflower","Watermelon","Citrus","Cotton","Groundnut",};
    String desc[] ={"This is sugarcane","This is banana","This is sunflower","This is watermelon",
            "This is citrus","This is cotton","This is groundnut"};
    int img[] = {R.drawable.sugarcane, R.drawable.banana,R.drawable.sunflower,R.drawable.watermelon,R.drawable.orange,
            R.drawable.cotton,R.drawable.groundnut};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.listview);
        Custom_ListView custom_listView = new Custom_ListView(this, name,desc,img );
        list.setAdapter(custom_listView);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(MainActivity.this,ThresholdActivity.class);
                intent.putExtra("name", name[position]);
                intent.putExtra("desc", desc[position]);
                intent.putExtra("image", img[position]);
                startActivity(intent);

            }
        });
    }
}
