package com.example.admin.mathemaking;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Derivativish extends AppCompatActivity {

    ImageView imgNotes, imgExamples, imgExercise, imgTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derivativish);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imgNotes = (ImageView) findViewById(R.id.imgDevishNotes);
        imgExamples = (ImageView) findViewById(R.id.imgDevishExamples);
        imgExercise = (ImageView) findViewById(R.id.imgDevishExercise);
        imgTest = (ImageView)findViewById(R.id.imgDevishTest);

        imgNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Derivativish.this,DevishNotes.class);
                startActivity(i);
            }
        });

        imgExamples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Derivativish.this,"Examples",Toast.LENGTH_SHORT).show();
                Intent i = new  Intent(Derivativish.this,DevishExamples.class);
                startActivity(i);
            }
        });

        imgExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Derivativish.this,"Exercise",Toast.LENGTH_SHORT).show();
            }
        });


        imgTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Derivativish.this,"Test",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
