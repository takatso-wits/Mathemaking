package com.example.admin.mathemaking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlphieOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphie_one);
    }

    public void startAlphieExamples(View view) {
        Intent intent  = new Intent(this, AlphieExamples.class);
        startActivity(intent);
    }
}
