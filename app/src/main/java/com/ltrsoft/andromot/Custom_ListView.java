package com.ltrsoft.andromot;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Custom_ListView extends ArrayAdapter<String> {

    private String[] name;
    private String[] desc;
    private int[] img;
    private Activity context;

    public Custom_ListView(Activity context, String name[], String[] desc, int[] img) {
        super(context, R.layout.listview_layout, name);

        this.context = context;
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r = convertView;
        ViewHolder viewHolder = null;
        if (r == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_layout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.image.setImageResource(img[position]);
        viewHolder.text1.setText(name[position]);
        viewHolder.text2.setText(desc[position]);
        return r;
    }

    class ViewHolder {
        TextView text1, text2;
        ImageView image;

        ViewHolder(View v) {
            text1 = (TextView) v.findViewById(R.id.tvName);
            text2 = (TextView) v.findViewById(R.id.tvDiscription);
            image = (ImageView) v.findViewById(R.id.imageView);
        }


    }
}
