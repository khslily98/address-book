package com.example.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Dummy> dummyDataList= new ArrayList<Dummy>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs) ;
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition() ;
                changeView(pos) ;
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // do nothing
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // do nothing
            }
        }) ;
    }



    //        get_json();
//
//        ListView listView = (ListView)findViewById(R.id.thelist);
//        final MyAdapter myAdapter = new MyAdapter(this,dummyDataList);
//
//        listView.setAdapter(myAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView parent, View v, int position, long id){
//                Toast.makeText(getApplicationContext(),
//                        myAdapter.getItem(position).getName(),
//                        Toast.LENGTH_LONG).show();
//            }
    private void changeView(int index) {
        ListView listView = (ListView)findViewById(R.id.thelist);
        TextView textView2 = (TextView) findViewById(R.id.text2) ;
        TextView textView3 = (TextView) findViewById(R.id.text3) ;

        switch (index) {
            case 0 :
                get_json();
                final MyAdapter myAdapter = new MyAdapter(this,dummyDataList);

                listView.setAdapter(myAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView parent, View v, int position, long id){
                        Toast.makeText(getApplicationContext(),
                                myAdapter.getItem(position).getName(),
                                Toast.LENGTH_LONG).show();
                    }
                });
                listView.setVisibility(View.VISIBLE) ;
                textView2.setVisibility(View.INVISIBLE) ;
                textView3.setVisibility(View.INVISIBLE) ;
                break ;
            case 1 :
                listView.setVisibility(View.INVISIBLE) ;
                textView2.setVisibility(View.VISIBLE) ;
                textView3.setVisibility(View.INVISIBLE) ;
                break ;
            case 2 :
                listView.setVisibility(View.INVISIBLE) ;
                textView2.setVisibility(View.INVISIBLE) ;
                textView3.setVisibility(View.VISIBLE) ;
                break ;

        }
    }
    public void get_json()
    {
        String json;
        try
        {
            InputStream is = getAssets().open("a.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for(int i =0; i<jsonArray.length();i++)
            {
                JSONObject obj = jsonArray.getJSONObject(i);
                String Name = jsonArray.getJSONObject(i).getString("name");
                String Phonenum = jsonArray.getJSONObject(i).getString("email");
                String Email = jsonArray.getJSONObject(i).getString("phone");

                dummyDataList.add(new Dummy(Name,Phonenum,Email));



            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
    }
}