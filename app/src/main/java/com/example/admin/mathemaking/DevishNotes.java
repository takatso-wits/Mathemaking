package com.example.admin.mathemaking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

public class DevishNotes extends AppCompatActivity {

    Button btnAxioms;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devish_notes);

        btnAxioms = (Button) findViewById(R.id.btnAxiomVisibility);
        scrollView = (ScrollView) findViewById(R.id.scrollVisibility);

        btnAxioms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DevishNotes.this,"Showing Axioms",Toast.LENGTH_SHORT).show();
                scrollView.setVisibility(View.VISIBLE);
            }
        });
    }
}
