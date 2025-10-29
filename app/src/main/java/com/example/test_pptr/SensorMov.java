package com.example.test_pptr;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test_pptr.R;

import java.text.DecimalFormat;

public class SensorMov extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor acelerometro;
    private TextView tvX, tvY, tvZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        tvX = findViewById(R.id.tvX);
        tvY = findViewById(R.id.tvY);
        tvZ = findViewById(R.id.tvZ);

        // Inicializar SensorManager y Acelerómetro
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager != null) {
            acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

        // Registrar el listener del sensor
        if (acelerometro != null) {
            sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            // Obtener valores de los ejes X, Y, Z
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            DecimalFormat deFo = new DecimalFormat("#.00");
            // Mostrar en pantalla
            tvX.setText("X: " + deFo.format(x));
            tvY.setText("Y: " + deFo.format(y));
            tvZ.setText("Z: " + deFo.format(z));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // No es necesario para esta práctica
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this); // Evita consumo innecesario de batería
    }
}