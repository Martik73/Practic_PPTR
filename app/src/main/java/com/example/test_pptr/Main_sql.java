package com.example.test_pptr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main_sql extends AppCompatActivity {

    EditText Ename, Elastname;
    Button btnadd, btnsearch;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.lite_sql);

        Ename = (EditText) findViewById(R.id.name);
        Elastname = (EditText) findViewById(R.id.lastname);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnsearch = (Button) findViewById(R.id.btnsearch);



        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db = new DB(getApplicationContext(), null, null, 1);
                String name = Ename.getText().toString();
                String lastname = Elastname.getText().toString();
                String message = db.save(name, lastname);
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_sql.this, Search_Delate_Update.class);
                startActivity(intent);
            }
        });
    }


}
