package com.example.admin.mathemaking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class DigitalNotes extends AppCompatActivity {

    Button digitalAxioms;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_notes);

        digitalAxioms = (Button)findViewById(R.id.btnDigitalAxioms);
        scrollView = (ScrollView)findViewById(R.id.scrollVisibility);

        digitalAxioms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.setVisibility(View.VISIBLE);
            }
        });
    }
}
