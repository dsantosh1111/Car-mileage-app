package com.example.santosh.carmileage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class mileage_calculator extends AppCompatActivity {
    Button save,load;
    EditText distance,gas,mileage1;
    Float Mileage;
    Float calculatedValue;
    int data_block=100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mileage_calculator);
        save = (Button) findViewById(R.id.save);
        load = (Button) findViewById(R.id.load);
        distance = (EditText) findViewById(R.id.distance);
        gas = (EditText) findViewById(R.id.gas);
        final TextView view1 = (TextView) findViewById(R.id.textView);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                Mileage = calculatedValue;

                try {
                    FileOutputStream fou = openFileOutput("text20.csv", MODE_APPEND);
                    OutputStreamWriter osw = new OutputStreamWriter(fou);
                    try {
                        osw.write(String.valueOf(Mileage));
                        osw.flush();
                        osw.close();
                        Toast.makeText(getBaseContext(), "Mileage :"+calculatedValue, Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = openFileInput("text2.csv");
                    InputStreamReader isr = new InputStreamReader(fis);
                    char[] data = new char[data_block];
                    String final_data = "";
                    int size;
                    try {
                        while ((size = isr.read(data)) > 0) {

                            String read_data = String.copyValueOf(data, 0, size);
                            view1.append(read_data);
                            view1.append("/n");
                            data = new char[data_block];
                        }
                        Toast.makeText(getBaseContext(), " :" +final_data, Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });



    }
    public void calculate(){
        //get entered texts from the edittexts,and convert to integers.
        Float value1 = Float.parseFloat(distance.getText().toString());
        Float value2 = Float.parseFloat(gas.getText().toString());
        //do the calculation
        calculatedValue = (Float) (value2/value1);
        //set the value to the textview, to display on screen.
    }
}
