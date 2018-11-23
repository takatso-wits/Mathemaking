package com.example.admin.mathemaking;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;

public class Derivative extends AppCompatActivity {
    ImageView derivativeNotes, derivativeExamples, derivativeExercise, derivativeTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derivative);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        derivativeNotes = (ImageView)findViewById(R.id.imgDerivativeNotes);
        derivativeExamples = (ImageView) findViewById(R.id.imgDerivativeExamples);
        derivativeExercise = (ImageView) findViewById(R.id.imgDerivativeExercise);
        derivativeTest = (ImageView)findViewById(R.id.imgDerivativeTest);


        derivativeNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Derivative.this,"Notes Clicked",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Derivative.this, DerivativeNotes.class);
                startActivity(intent);
            }
        });

        derivativeExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Derivative.this,"Exercise Clicked",Toast.LENGTH_SHORT).show();

            }
        });

        derivativeExamples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Derivative.this,"Example Clicked",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Derivative.this,DerivativeExamples.class);
                startActivity(intent);

            }
        });

        derivativeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Derivative.this,"Test Clicked",Toast.LENGTH_SHORT).show();

            }
        });

    }

}
