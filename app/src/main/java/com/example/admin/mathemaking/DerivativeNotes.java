package com.example.admin.mathemaking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class DerivativeNotes extends AppCompatActivity {
    Button btnAxioms;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derivative_notes);

        btnAxioms = (Button) findViewById(R.id.btnDerivativeAxioms);
        scrollView = (ScrollView) findViewById(R.id.scrollVisibility);

        btnAxioms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.setVisibility(View.VISIBLE);
            }
        });

    }
}
