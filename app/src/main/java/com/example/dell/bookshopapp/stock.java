package com.example.dell.bookshopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class stock extends AppCompatActivity {
ListView listView;
ArrayList<String>array;
ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        listView=findViewById(R.id.listview);
        array =new ArrayList<>();

        array.add("Atlas");
        array.add("Dictionary");
        array.add("encyclopedia");
        array.add("yearbook");
        array.add("Thesaurus");
        array.add("comics");
        array.add("fantasies");
        array.add("journals");
        array.add("novels");
        array.add("bible");
        array.add("playbook");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),""+array.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }
}
