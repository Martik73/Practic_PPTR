package com.example.test_pptr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class registro extends AppCompatActivity implements View.OnClickListener {

    private Button b5 ;
    private TextView tex;
    private EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        b5 = (Button) findViewById(R.id.button5);
        tex = (TextView) findViewById(R.id.textView4);
        e1 = (EditText) findViewById(R.id.editTextText);

        b5.setOnClickListener(this);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view){
        String user = e1.getText().toString();
        tex.setText("Hola "+user);
        //If (gil)

    }

}

