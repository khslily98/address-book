package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context context;

    public Integer[] images = {
            R.drawable.fast_parrot, R.drawable.aaw_yeah,
            R.drawable.aaw_yeah, R.drawable.fast_parrot,
            R.drawable.aaw_yeah, R.drawable.aaw_yeah,
            R.drawable.fast_parrot, R.drawable.aaw_yeah,
            R.drawable.aaw_yeah, R.drawable.aaw_yeah,
            R.drawable.aaw_yeah, R.drawable.aaw_yeah,
            R.drawable.aaw_yeah, R.drawable.fast_parrot,
            R.drawable.fast_parrot, R.drawable.aaw_yeah,
            R.drawable.aaw_yeah, R.drawable.aaw_yeah,
            R.drawable.fast_parrot, R.drawable.aaw_yeah,
            R.drawable.aaw_yeah, R.drawable.fast_parrot,
            R.drawable.aaw_yeah, R.drawable.aaw_yeah,
            R.drawable.fast_parrot, R.drawable.aaw_yeah,
            R.drawable.aaw_yeah, R.drawable.aaw_yeah,
            R.drawable.aaw_yeah, R.drawable.aaw_yeah,
            R.drawable.aaw_yeah, R.drawable.fast_parrot,
            R.drawable.fast_parrot, R.drawable.aaw_yeah,
            R.drawable.aaw_yeah, R.drawable.aaw_yeah
    };

    public ImageAdapter(Context c){
        context = c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(240,240));
        return imageView;
    }
}