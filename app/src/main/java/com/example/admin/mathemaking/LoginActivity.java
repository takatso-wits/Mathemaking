package com.example.admin.mathemaking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button exam, progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        exam = findViewById(R.id.btnExam);
        progress = findViewById(R.id.btnProgress);

        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Exam not ready.",Toast.LENGTH_SHORT).show();
            }
        });
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"0% Complete",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.course_list,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.topic1:
                finish();
                intent = new Intent(getApplicationContext(), AlphieCombinations.class);
                startActivity(intent);
                return true;
            case R.id.topic2:
                intent = new Intent(getApplicationContext(), Derivativish.class);
                startActivity(intent);
                return true;
            case R.id.topic3:
                intent = new Intent(getApplicationContext(), DigitalTrading.class);
                startActivity(intent);
                return true;
            case R.id.topic4:
                intent = new Intent(getApplicationContext(), SumsDigitalTrading.class);
                startActivity(intent);
                return true;
            case R.id.topic5:
                intent = new Intent(getApplicationContext(), Ncanyana.class);
                startActivity(intent);
                return true;
            case R.id.topic6:
                intent = new Intent(getApplicationContext(), SpecialDecimals.class);
                startActivity(intent);
                return true;
            case R.id.topic7:
                intent = new Intent(getApplicationContext(), DecimalsNthDegree.class);
                startActivity(intent);
                return true;
            case R.id.topic8:
                intent = new Intent(getApplicationContext(), DecimalsNegativeNthDegree.class);
                startActivity(intent);
                return true;
            case R.id.topic9:
                intent = new Intent(getApplicationContext(), AbridgingCoincidences.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
