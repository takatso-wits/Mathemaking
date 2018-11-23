package com.example.admin.mathemaking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpecialDecimals extends AppCompatActivity {
    Button btnNextTopic,btnNextTopic2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_decimals);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnNextTopic2 = (Button)findViewById(R.id.btnChapterEight);
        btnNextTopic = (Button)findViewById(R.id.btnChapterSeven);


        btnNextTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DecimalsNthDegree.class);
                startActivity(intent);
            }
        });

        btnNextTopic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DecimalsNegativeNthDegree.class);
                startActivity(intent);
            }
        });
    }
}
