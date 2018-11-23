package com.example.admin.mathemaking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;

public class AlphieCombinations extends AppCompatActivity {

    ImageView exercise, test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphie_combinations);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        test = (ImageView) findViewById(R.id.btnAlphieTest);
        exercise = (ImageView) findViewById(R.id.btnAlphieExercise);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(AlphieCombinations.this,AlphieTest.class);
                 startActivity(intent);
                Toast.makeText(AlphieCombinations.this,"Test Acivity", Toast.LENGTH_SHORT).show();
            }
        });

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlphieCombinations.this, AlphieExercise.class);
                startActivity(intent);
                Toast.makeText(AlphieCombinations.this,"Exercise Acivity", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void startAlphieNotes(View view) {
        Intent intent = new Intent(this,AlphieNotes.class);
        startActivity(intent);
    }

    public void startAlphieExamples(View view) {
        Intent intent = new Intent(this, AlphieExamples.class);
        startActivity(intent);
    }
}
