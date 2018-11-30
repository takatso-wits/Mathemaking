package com.example.admin.mathemaking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.mathemaking.R;
import com.example.admin.mathemaking.RegistrationActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLogin;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        tv = findViewById(R.id.tv_newAccount);
        btnLogin.setOnClickListener(this);
        tv.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == btnLogin){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        }
        if(v == tv){
            Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
            startActivity(intent);

        }
    }
}