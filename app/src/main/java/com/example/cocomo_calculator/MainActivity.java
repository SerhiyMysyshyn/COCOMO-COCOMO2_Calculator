package com.example.cocomo_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cocomo_calculator.COCOMO.cocomo1;
import com.example.cocomo_calculator.COCOMO_II.cocomo2;
import com.example.cocomo_calculator.FUNCTIONAL_POINTS.functional_points;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cocomo1_button = (Button)findViewById(R.id.cocomo_button);
        Button cocomo2_button = (Button)findViewById(R.id.cocomo2_button);
        Button fPoints = (Button)findViewById(R.id.functionalPoints_button);

        cocomo1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cocomo1.class);
                startActivity(intent);
            }
        });

        cocomo2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cocomo2.class);
                startActivity(intent);
            }
        });

        fPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, functional_points.class);
                startActivity(intent);
            }
        });

    }
}