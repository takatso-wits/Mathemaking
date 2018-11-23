package com.example.admin.mathemaking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AlphieFive extends AppCompatActivity {
    EditText q1;
    int ans1;
    Button submit;
    RadioButton correctAnswer,userAnswer;
    TextView textView;
    String formula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphie_five);

        submit = (Button) findViewById(R.id.btnSubmit5);
        correctAnswer = (RadioButton)findViewById(R.id.radioBtnA);
        q1 = (EditText)findViewById(R.id.edAnsToYield5);
        textView = (TextView)findViewById(R.id.testingPowers);

        formula =  "<sup>(x + y)</sup>/<sup>( x<sup>3</sup> + y )<sup>3</sup> = 4";

        /*It works perfectly.... I love it.*/

        textView.setText(Html.fromHtml(formula));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ans1 = Integer.parseInt(q1.getText().toString());
                if(correctAnswer.isChecked() == true && ans1 == 6){
                    Toast.makeText(getApplicationContext(),"Your answer is correct",Toast.LENGTH_SHORT).show();
                    q1.setText("");
                    correctAnswer.setChecked(false);
                }else{
                    Toast.makeText(getApplicationContext(),"Your answer is not correct",Toast.LENGTH_SHORT).show();
                    q1.setText("");
                    correctAnswer.setChecked(false);

                }
            }
        });

    }

}
