package com.example.fitpartner;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    TextInputEditText edtusername,edtpassword, edtnama, edtemail;

    private Button btnRegister;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    ProgressBar progressBar;
    private TextView testaja;
    private TextView masuk;
    private Button btnLogin;
    String userID;

    /*public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), Profil.class);
            startActivity(intent);
            finish();
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        edtusername = findViewById(R.id.edt_username);
        edtpassword = findViewById(R.id.edt_password);
        edtnama = findViewById(R.id.edt_username);
        edtemail = findViewById(R.id.email2);
        progressBar = findViewById(R.id.progressBar);
        masuk = findViewById(R.id.masuk);
        /*baliklogin = findViewById(R.id.balik_login);
        baliklogin.setOnClickListener((v -> {
            if (v.getId() == R.id.balik_login) {
                Intent balik = new Intent(MoveActivity.this, MainActivity.class);
                startActivity(balik);
            }
        }
        ));*/
        masuk.setOnClickListener((v-> {
            if (v.getId() == R.id.masuk) {
                Intent balik = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(balik);
            }
        }
        ));
        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                /*String username = edtusername.getText().toString();
                String password = edtpassword.getText().toString();
                String nama = edtnama.getText().toString();
                String email = edtemail.getText().toString();*/
                String  email, username, password, nama;
                email = String.valueOf(edtemail.getText());
                username = String.valueOf(edtusername.getText());
                password = String.valueOf(edtpassword.getText());
                nama = String.valueOf(edtnama.getText());
                //data ke profil

                //data ke login
                /*Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                intent.putExtra("email", email);
                intent.putExtra("nama", nama);
                startActivity(intent);*/
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity2.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                /*if (TextUtils.isEmpty(username)){
                    Toast.makeText(MainActivity2.this, "Enter username", Toast.LENGTH_SHORT).show();
                    return;
                }*/
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity2.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                /*if (TextUtils.isEmpty(nama)){
                    Toast.makeText(MainActivity2.this, "Enter nama", Toast.LENGTH_SHORT).show();
                    return;
                }*/
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(MainActivity2.this, "Akun dibuat.",
                                            Toast.LENGTH_SHORT).show();
                                    userID = mAuth.getCurrentUser().getUid();
                                    DocumentReference documentReference = fStore.collection("user").document(userID);
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("fName", nama);
                                    user.put("fUsername", username);
                                    user.put("Email", email);
                                    /*user.put("Role", role);*/
                                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "Berhasil user"+ userID);
                                        }
                                    });



                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity2.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
           /*auth.
                   createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener( this, new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d( TAG, "createUserWithEmail:success" );
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI( user );
                    } else {
                        Log.w(TAG, "createUserWithEmail:failed");
                        Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                        updateUI( null );
                    }
                }
            } );


        });*/
        });
    }
}