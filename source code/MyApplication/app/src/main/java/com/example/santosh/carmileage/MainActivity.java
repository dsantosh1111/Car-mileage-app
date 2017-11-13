package com.example.santosh.carmileage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    Button button_photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_photo = (Button) findViewById(R.id.button);
        button_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, mileage_calculator.class);
                startActivity(i);
            }
        });

        Button button_maps = (Button) findViewById(R.id.button2);
        button_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, mileage_calculator.class);
                startActivity(i);
            }
        });

    }






}
