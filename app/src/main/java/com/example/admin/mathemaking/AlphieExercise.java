package com.example.admin.mathemaking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AlphieExercise extends AppCompatActivity {

    ImageView imageView4,imageView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphie_exercise);

        imageView4 = (ImageView) findViewById(R.id.alphie4);
        imageView5 = (ImageView) findViewById(R.id.alphie5);

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlphieExercise.this,AlphieFour.class);
                startActivity(intent);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlphieExercise.this,AlphieFive.class);
                startActivity(intent);
            }
        });    }
}
