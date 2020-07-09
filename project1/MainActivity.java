package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Dummy> dummylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeDummyData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this,dummylist);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),
                        myAdapter.getItem(position).getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void InitializeDummyData()
    {
        ArrayList<Dummy> dummyDataList = new ArrayList<Dummy>();

        dummyDataList.add(new Dummy( "Json", "010-9809-1626","jmg2107@kaist.ac.kr"));
        dummyDataList.add(new Dummy( "Amazon", "042-350-1432","amazon@aws"));
        dummyDataList.add(new Dummy( "HTML", "000-1234-123",""));
    }
}