package com.example.fitpartner;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class BayarKelasActivity extends AppCompatActivity {
    private EditText speciality;
    private EditText edittext,nama_bank, rekening, name,nominal,trainerId;
    private EditText experience;
    private EditText certification;
    private EditText judul;
    private EditText description;
    private EditText image;
    private EditText level;
    private EditText starttime,harga;
    private EditText endtime;
    private EditText jadwal;
    private EditText lokasi;
    private EditText jam;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar_kelas);
        nama_bank = findViewById(R.id.nama_bank_id);
        rekening = findViewById(R.id.rekening_id);
        nominal = findViewById(R.id.nominal_id);
        name = findViewById(R.id.name_id);
        String trainerId = getIntent().getStringExtra("TrainerId");
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String userId = mAuth.getCurrentUser().getUid();


    }
    public void daftarkelas(View v) {
        String nama_bank_, rekening_, name_, nominal_;
        nama_bank_ = String.valueOf(nama_bank.getText());
        rekening_ = String.valueOf(rekening.getText());
        name_ = String.valueOf(name.getText());
        nominal_ = String.valueOf(nominal.getText());

        Intent intent = getIntent();
        String trainerId = intent.getStringExtra("TrainerId"); // Retrieve TrainerId from the previous activity
        String judul_ = intent.getStringExtra("judul");
        String jadwal_= intent.getStringExtra("jadwal");
        String lokasi_= intent.getStringExtra("lokasi");
        String student = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // Koleksi Pembayaran
        String collectionPathPembayaran = "Pembayaran";
        CollectionReference collectionRefPembayaran = fStore.collection(collectionPathPembayaran);
        Map<String, Object> dataPembayaran = new HashMap<>();
        dataPembayaran.put("status", "pending");
        dataPembayaran.put("userId", student);
        dataPembayaran.put("namabank", nama_bank_);
        dataPembayaran.put("rekening", rekening_);
        dataPembayaran.put("name", name_);
        dataPembayaran.put("nominal", nominal_);
        dataPembayaran.put("TrainerId", trainerId); // Add TrainerId to the payment data

        collectionRefPembayaran.add(dataPembayaran)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        String documentIdPembayaran = documentReference.getId();
                        Intent intentpindah = new Intent(BayarKelasActivity.this, Profil.class);

                        startActivity(intentpindah);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Error adding payment document: " + e.getMessage());
                    }
                });
        Intent intentbayar = new Intent(BayarKelasActivity.this, DetailStatusPembayaran.class);
        intentbayar.putExtra("judul", getIntent().getStringExtra("judul"));
        intentbayar.putExtra("jadwal", getIntent().getStringExtra("jadwal"));
        intentbayar.putExtra("jam", getIntent().getStringExtra("jam"));
        intentbayar.putExtra("harga", getIntent().getStringExtra("harga"));
        intentbayar.putExtra("lokasi", getIntent().getStringExtra("lokasi"));
        intentbayar.putExtra("rekening", getIntent().getStringExtra("rekening"));
        intentbayar.putExtra("level", getIntent().getStringExtra("level"));
        intentbayar.putExtra("starttime", getIntent().getStringExtra("starttime"));
        intentbayar.putExtra("TrainerId", getIntent().getStringExtra("TrainerId"));
        intentbayar.putExtra("judul", getIntent().getStringExtra("judul"));
        intentbayar.putExtra("jadwal", getIntent().getStringExtra("jadwal"));
        intentbayar.putExtra("jam", getIntent().getStringExtra("jam"));
        intentbayar.putExtra("harga", getIntent().getStringExtra("harga"));
        intentbayar.putExtra("lokasi", getIntent().getStringExtra("lokasi"));
        intentbayar.putExtra("nominal", getIntent().getStringExtra("nominal"));
        intentbayar.putExtra("userId", getIntent().getStringExtra("userId"));
        intentbayar.putExtra("adasd", getIntent().getStringExtra("waw"));
        startActivity(intentbayar);
    }

}

