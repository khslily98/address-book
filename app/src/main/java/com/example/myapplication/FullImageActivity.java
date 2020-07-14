package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import fragmentClasses.Fragment_Second;

public class FullImageActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        Intent i = getIntent();

        final int position = i.getExtras().getInt("id");
        ImageAdapter adapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(adapter.images[position]);


        imageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                finish();
            }
        });

    }
}