package com.example.admin.mathemaking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlphieExamples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphie_examples);
    }

    public void startAlphieOne(View view) {
        Intent intent = new Intent(this,AlphieOne.class);
        startActivity(intent);
    }
    public void startAlphieTwo(View view) {
        Intent intent = new Intent(this,AlphieTwo.class);
        startActivity(intent);
    }
    public void startAlphieThree(View view) {
        Intent intent = new Intent(this,AlphieThree.class);
        startActivity(intent);
    }
    public void startAlphieFour(View view) {
        Intent intent = new Intent(this,AlphieFour.class);
        startActivity(intent);
    }
    public void startAlphieFive(View view) {
        Intent intent = new Intent(this,AlphieFive.class);
        startActivity(intent);
    }
    public void startAlphieSix(View view) {
        Intent intent = new Intent(this,AlphieSix.class);
        startActivity(intent);
    }
    public void startAlphieSeven(View view) {
        Intent intent = new Intent(this,AlphieSeven.class);
        startActivity(intent);
    }
    public void startAlphieEight(View view) {
        Intent intent = new Intent(this,AlphieEight.class);
        startActivity(intent);
    }
    public void startAlphieNine(View view) {
        Intent intent = new Intent(this,AlphieNine.class);
        startActivity(intent);
    }

}
