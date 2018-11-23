package com.example.admin.mathemaking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AlphieFour extends AppCompatActivity {

    EditText edAns;
    Button btnSubmit;
    int answer;
    TextView tvVisibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphie_four);

        tvVisibility = (TextView) findViewById(R.id.tvAddition);
        edAns = (EditText) findViewById(R.id.edAnsToYield1);
        btnSubmit = (Button)findViewById(R.id.btnSubmitAns1);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = Integer.parseInt(edAns.getText().toString());
                if(answer == 5){
                    Toast.makeText(AlphieFour.this,"Your Answer is correct",Toast.LENGTH_SHORT).show();
                    tvVisibility.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(AlphieFour.this,"Your Answer is incorrect",Toast.LENGTH_SHORT).show();
                    tvVisibility.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}
