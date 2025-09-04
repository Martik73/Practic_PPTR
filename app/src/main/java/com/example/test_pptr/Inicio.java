package com.example.test_pptr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    private Button b, b2;

    private Button r;
    private TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incio);

        b = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button4);
        r = (Button) findViewById(R.id.button6);
        t = (TextView) findViewById(R.id.textView5);

        b.setOnClickListener(this);

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View view){
                 Toast.makeText(Inicio.this, "Esto es un toast", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(Inicio.this, MainActivity.class);
                 startActivity(intent);
            }
        });

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onClick(View v) {
        t.setText("Asi me gusta, sumiso");
    }
}
