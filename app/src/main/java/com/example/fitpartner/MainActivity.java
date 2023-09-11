package com.example.fitpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edtusername,edtpassword, edtnama, edtemail;
    private TextView testaja;
    private TextView daftar;
    private Button btnLogin;
    FirebaseAuth mAuth;
    ProgressBar progressbar;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), Dashboard.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        //edtusername = findViewById(R.id.edt_username);
        edtemail = findViewById(R.id.edt_email);
        edtpassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        progressbar = findViewById(R.id.progressBar);
        daftar = findViewById(R.id.daftar);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });

        /*btnLogin.setOnClickListener(v -> {
           /* String username = edtusername.getText().toString();
            String password = edtpassword.getText().toString();

            String registeredUsername = intent.getStringExtra("username");
            String registeredPassword = intent.getStringExtra("password");
           Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            */
            /*progressBar.setVisibility(View.VISIBLE);
            String email, password, username, nama;
            email = String.valueOf(edtemail.getText());
            username = String.valueOf(edtusername.getText());
            password = String.valueOf(edtpassword.getText());
            nama = String.valueOf(edtnama.getText());
            if (TextUtils.isEmpty(email)){
                Toast.makeText(MainActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)){
                Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.signInWithEmailAndPassword(email, password)
            //progressBar.setVisibility(View.GONE);
                    .addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(
                        @NonNull Task<AuthResult> task)
                                {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplicationContext(), "Berhasil Login", Toast.LENGTH_SHORT).show();
                            //Intent intent = new Intent(MainActivity.this, Profil.class);
                            Intent  intent = new Intent(getApplicationContext(), test.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

            /*if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
                Intent intentP = new Intent(MainActivity.this, Profil.class);
                intentP.putExtra("username", registeredUsername);
                startActivity(intentP);
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
            }
        });*/
        daftar.setOnClickListener((v-> {
            if (v.getId() == R  .id.daftar) {
                Intent balik = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(balik);
            }
        }
        ));
    }

    private void loginUserAccount() {
        progressbar.setVisibility(View.VISIBLE);

        // Take the value of two edit texts in Strings
        String email, password, username, nama;
        email = String.valueOf(edtemail.getText());
        //username = String.valueOf(edtusername.getText());
        password = String.valueOf(edtpassword.getText());

        // validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter email!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // signin existing user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Login successful!!", Toast.LENGTH_LONG).show();

                                    // hide the progress bar
                                    progressbar.setVisibility(View.GONE);

                                    // if sign-in is successful
                                    // intent to home activity
                                    Intent intent = new Intent(MainActivity.this, Dashboard.class);
                                    startActivity(intent);
                                }

                                else {

                                    // sign-in failed
                                    Toast.makeText(getApplicationContext(),
                                                    "Login failed!!", Toast.LENGTH_LONG).show();
                                    // hide the progress bar
                                    progressbar.setVisibility(View.GONE);
                                }
                            }
                        });
    }
}