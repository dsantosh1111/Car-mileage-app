package com.example.santosh.carmileage;

/**
 * Created by santosh on 9/28/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity {

    Button button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        button_register = (Button) findViewById(R.id.button6);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Register.this, Login.class);
                startActivity(i4);
            }
        });


    }
}
