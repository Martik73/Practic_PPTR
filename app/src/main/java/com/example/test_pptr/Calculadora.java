package com.example.test_pptr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Calculadora extends AppCompatActivity implements View.OnClickListener {


    private Button buttonResult;
    private TextView textResult;
    private EditText num1, num2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


        buttonResult= (Button) findViewById(R.id.res);
        textResult = (TextView) findViewById(R.id.textView8);
        num1 = (EditText) findViewById(R.id.primis);
        num2 = (EditText) findViewById(R.id.segundo);
        buttonResult.setOnClickListener(this);

    }
    @Override
    public void onClick(View view){
        String numero = num1.getText().toString();
        String numero2 = num2.getText().toString();
        int n1 = Integer.parseInt(numero);
        int n2 = Integer.parseInt(numero2);
        textResult.setText("Resultado de la suma = " + (n1 + n2) + "\nResultado de la resta = " + (n1 - n2) +
        "\nResultado de la multi = " +(n1 * n2) + "\nResultado de la división = " +(n1 / n2));
    }
}
