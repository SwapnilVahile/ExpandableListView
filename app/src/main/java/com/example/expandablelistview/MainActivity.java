package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;
    ExpandableListSetAdapter explistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expListView=findViewById(R.id.lvExp); //get listview

        prepareListData();  //Prepared the list for Header and child

        //Invoking the adapter to transfer data on ExpandableListView
        explistAdapter=new ExpandableListSetAdapter(this,listDataHeader,listDataChild);
        expListView.setAdapter(explistAdapter);
    }

    private void prepareListData() {
      listDataHeader=new ArrayList<>();
      listDataChild=new HashMap<>();

      //Add Header Data
        listDataHeader.add("Top");
        listDataHeader.add("Top Cov");
        listDataHeader.add("Top not Cov");

        //Add Child Data
        List<String> top250=new ArrayList<>();
        top250.add("Android");
        top250.add("Android");
        top250.add("Android Arch..");
        top250.add("Android SDK");
        top250.add("Android UI");
        top250.add("Android Notification");
        top250.add("Android Maps");
        top250.add("Android Bluetooth");
        top250.add("Android WIFI");

        List<String> nowShowing=new ArrayList<>();
        nowShowing.add("Android");
        nowShowing.add("Android Arch..");
        nowShowing.add("Android SDK");
        nowShowing.add("Android UI");
        nowShowing.add("Android Notification");

        List<String> comingsoon=new ArrayList<>();
        comingsoon.add("Android Maps");
        comingsoon.add("Android Bluetooth");
        comingsoon.add("Android WIFI");

        listDataChild.put(listDataHeader.get(0),top250);
        listDataChild.put(listDataHeader.get(1),nowShowing);
        listDataChild.put(listDataHeader.get(2),comingsoon);





    }
}
