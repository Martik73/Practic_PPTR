package com.example.test_pptr;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class List extends AppCompatActivity {

    private ListView listView;
    private ArrayList xd;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listview);

        xd = new ArrayList<String>();
        xd.add("Camion");
        xd.add("Juan");
        xd.add("Ernesto");
        xd.add("Hola");
        xd.add("Esternomascloideo");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, xd);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(List.this, "Seleccionaste " + xd.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
