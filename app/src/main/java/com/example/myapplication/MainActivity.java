package com.example.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import fragmentClasses.Fragment_First;
import fragmentClasses.Fragment_Second;
import fragmentClasses.Fragment_Third2;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
    public void setupViewPager(ViewPager viewPager) {
        adapter.addFragment(new Fragment_First(), "Addressbook");
        adapter.addFragment(new Fragment_Second(), "Gallery");
        adapter.addFragment(new Fragment_Third2(), "Do not Try");
        viewPager.setAdapter(adapter);
    }

}