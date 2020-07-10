package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<Dummy> sample;

    public MyAdapter(Context context, ArrayList<Dummy> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Dummy getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.listview_custom, null);

        TextView Name = (TextView)view.findViewById(R.id.Name);
        TextView PhoneNum = (TextView)view.findViewById(R.id.PhoneNum);
        TextView Email = (TextView)view.findViewById(R.id.Email);

        Name.setText(sample.get(position).getName());
        PhoneNum.setText(sample.get(position).getPhoneNum());
        Email.setText(sample.get(position).getEmail());

        return view;
    }
}