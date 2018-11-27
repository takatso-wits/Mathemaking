package com.example.admin.mathemaking;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private static FirebaseUser firebaseUser;
    private EditText etUsername;
    private  EditText etPassword;
    private Button btnRegister;
    private CheckBox checkBox;
    private ProgressDialog progressDialog;
    static FirebaseUser user = null;
    private FirebaseAuth firebaseAuth;
    static String userName;
    static String userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_passwword);
        checkBox = findViewById(R.id.checkBx);
        btnRegister = findViewById(R.id.btn_reg);

        if(firebaseAuth.getCurrentUser() != null){
            //finish();
            /*Take the user to home*/
        }
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnRegister){
            registerUser();
        }
    }

    private void registerUser() {
        userName = etUsername.getText().toString().trim();
        userPass = etPassword.getText().toString().trim();

        if(!isValidEmail(userName)){
            etUsername.setError("Invalid email!");
            return;
        }
        if(!isValidPassword(userPass)){
            etPassword.setError("Password can't be less than 4 characters or null!");
            return;
        }
        progressDialog.setMessage("You are being registered...");
        progressDialog.show();
        if(  isConnectingToInternet(RegistrationActivity.this) == false) {
            progressDialog.dismiss();
            firebaseAuth.createUserWithEmailAndPassword(userName, userPass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                user = FirebaseAuth.getInstance().getCurrentUser();

                                    /*Successfully Registered*/

                                    Toast.makeText(getApplicationContext(),
                                            "Registered",
                                            Toast.LENGTH_SHORT).show();

                                if(!user.isEmailVerified()) {
                                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(RegistrationActivity.this, "Please click the sent Verification Link to your email", Toast.LENGTH_LONG).show();
                                        }
                                    });
                                }

                            }


                        }
                    });
        }
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
    private boolean isValidPassword(String pass) {
        return pass != null && pass.length() >= 4;
    }

    private boolean isConnectingToInternet(RegistrationActivity registrationActivity) {
        ConnectivityManager conMan = (ConnectivityManager) registrationActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
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
            return reachable;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

