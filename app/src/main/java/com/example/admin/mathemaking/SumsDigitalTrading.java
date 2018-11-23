package com.example.admin.mathemaking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SumsDigitalTrading extends AppCompatActivity {

    ImageView imgNote,imgExample,imgExercise,imgTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sums_digital_trading);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgNote = (ImageView)findViewById(R.id.imgSumDigitalNotes);
        imgExample = (ImageView)findViewById(R.id.imgSumDigitalExamples);
        imgExercise = (ImageView)findViewById(R.id.imgSumDigitalExercise);
        imgTest = (ImageView)findViewById(R.id.imgSumDigitalTest);


        imgNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SumDigitalNotes.class);
                startActivity(intent);
            }
        });

        imgTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SumDigitalTest.class);
                startActivity(intent);
            }
        });
        imgExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SumDigitalExample.class);
                startActivity(intent);
            }
        });
        imgExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SumDigitalExercise.class);
                startActivity(intent);
            }
        });



    }
}
