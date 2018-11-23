package com.example.admin.mathemaking;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class DigitalTrading extends AppCompatActivity {

    ImageView digitalNotes, digitalExamples, digitalExercise, digitalTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_trading);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        digitalNotes = (ImageView) findViewById(R.id.imgDigitalNotes);
        digitalExamples = (ImageView) findViewById(R.id.imgDigitalExamples);
        digitalExercise = (ImageView)findViewById(R.id.imgDigitalExercise);
        digitalTest = (ImageView)findViewById(R.id.imgDigitalTest);

        digitalNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DigitalTrading.this,"Notes Button Clicked",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DigitalTrading.this, DigitalNotes.class);
                startActivity(intent);
            }
        });

        digitalExamples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DigitalTrading.this,"Examples Button Clicked",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DigitalTrading.this, DigitalExample.class);
                startActivity(intent);
            }
        });
        digitalExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DigitalTrading.this,"Exercise Button Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        digitalTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DigitalTrading.this,"Test Button Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
