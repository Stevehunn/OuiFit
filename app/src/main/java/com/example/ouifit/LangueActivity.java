package com.example.ouifit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LangueActivity extends Activity {

    ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.langue);

        ListView = (ListView) findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Français");
        arrayList.add("Anglais");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.langue, arrayList);

        ListView.setAdapter(arrayAdapter);
    }
}
