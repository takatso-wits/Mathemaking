package com.example.admin.mathemaking;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    EditText etUsername, etPassword;
    Button loginButton;
    TextView tvRegister;
    static FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        getSupportActionBar().setTitle("Registration");

        /*Get the reference Variables*/
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_passwword);
        loginButton = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_newAccount);

        loginButton.setOnClickListener(this);
        tvRegister.setOnClickListener(this);



        /**/

    }

    @Override
    public void onClick(View v) {
        if(v == loginButton){
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            /*Validate the user input*/
            if(!isValidEmail(username)){
                etUsername.setError("Invalid Email!");
                return;
            }
            if(!isValidPassword(password)){
                etPassword.setError("Password Invalid!");
                return;
            }
            progressDialog.setTitle("Logging In");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            firebaseAuth.signInWithEmailAndPassword(username,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (isConnectingToInternet(LoginActivity.this) == false) {
                                AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext()).create();
                                alertDialog.setTitle("Alert");
                                alertDialog.setMessage("You are not connected to the Internet.");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                                alertDialog.show();
                                progressDialog.dismiss();
                                return;

                            }else if(isConnectingToInternet(LoginActivity.this) == true){
                                firebaseAuth = FirebaseAuth.getInstance();
                                firebaseAuth.fetchProvidersForEmail(etUsername.getText().toString())
                                        .addOnCompleteListener(new OnCompleteListener<ProviderQueryResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<ProviderQueryResult> task) {
                                                if(!task.getResult().getProviders().isEmpty()){
                                                    if (task.isSuccessful()) {
                                                        progressDialog.dismiss();
                                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                                        startActivity(intent);
                                                    }else{
                                                        Toast.makeText(getApplicationContext(),"Authentication Failed",Toast.LENGTH_SHORT).show();
                                                    }

                                                }else {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext()).create();
                                                    alertDialog.setTitle("Alert");
                                                    alertDialog.setMessage("You are not registered.");
                                                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                                            new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    dialog.dismiss();
                                                                }
                                                            });
                                                    alertDialog.show();
                                                    progressDialog.dismiss();
                                                    return;

                                                }
                                            }
                                        });
                            }

                        }
                    });

        }else if(v == tvRegister){
            Toast.makeText(getApplicationContext(),"New Account Requested",Toast.LENGTH_LONG).show();
        }

    }

    private boolean isConnectingToInternet(LoginActivity loginActivity) {

        ConnectivityManager conMan = (ConnectivityManager) loginActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
//mobile
        NetworkInfo.State mobile = conMan.getNetworkInfo(0).getState();
//wifi
        NetworkInfo.State wifi = conMan.getNetworkInfo(1).getState();
        if (mobile == NetworkInfo.State.CONNECTED || mobile == NetworkInfo.State.CONNECTING )
        {
            return isOnline() == true;
        }
        else if (wifi == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTING  ) {

            return hostAvailable() == true;
        }
        return false;
    }

    private boolean isValidPassword(String pass) {
        return pass != null && pass.length() >= 4;
    }

    private boolean isValidEmail(String email) {

        if (email != null){
            String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        return false;
    }
    static boolean wifiIsConnected = true;
    final static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static boolean hostAvailable() {


        final DatabaseReference connectedRef = database.getReference(".info/connected");
        connectedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                boolean connected = snapshot.getValue(Boolean.class);
                if (connected) {
                    wifiIsConnected = true;
                }
                else{
                    wifiIsConnected = false;
                    firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                    final DatabaseReference myConnectionsRef = database.getReference("users/connections");
                    DatabaseReference con = myConnectionsRef.push();
                    con.onDisconnect().removeValue();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        return wifiIsConnected;
    }
    public static boolean isOnline() {

        try {

            Process p1 = Runtime.getRuntime().exec("ping -c 1 www.google.com");
            int returnVal = p1.waitFor();
            boolean reachable = (returnVal==0);

            //System.out.println("Internet access");
//System.out.println("No Internet access");
            return reachable;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
