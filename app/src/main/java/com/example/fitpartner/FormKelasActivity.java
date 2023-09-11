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


public class FormKelasActivity extends AppCompatActivity {
    private EditText speciality;
    private EditText edittext;
    private EditText experience;
    private EditText certification;
    private EditText judul;
    private EditText description;
    private EditText image;
    private EditText level;
    private EditText starttime,harga;
    private EditText endtime;
    private EditText jadwal;
    private EditText rekening;
    private EditText lokasi;
    private EditText jam;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_kelas);
        speciality = findViewById(R.id.specialty_id);
        experience = findViewById(R.id.experience_id);
        certification = findViewById(R.id.certification_id);
        judul = findViewById(R.id.judul_id);;
        description = findViewById(R.id.description_id);
        image = findViewById(R.id.image_id);
        level = findViewById(R.id.level_id);
        starttime = findViewById(R.id.starttime_id);
        endtime = findViewById(R.id.endtime_id);
        jadwal = findViewById(R.id.jadwal_id);
        rekening = findViewById(R.id.rekening_id);
        harga = findViewById(R.id.harga_id);
        lokasi = findViewById(R.id.lokasi_id);
        jam = findViewById(R.id.jam_id);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String userId = mAuth.getCurrentUser().getUid();


    }
    public void daftarkelas(View v){
        String speciality_ ,experience_, certification_, judul_, description_, image_, level_, starttime_, endtime_, jadwal_, rekening_, lokasi_, jam_, harga_;
        speciality_ = String.valueOf(speciality.getText());
        experience_ = String.valueOf(experience.getText());
        certification_= String.valueOf(certification.getText());
        judul_ = String.valueOf(judul.getText());
        description_ = String.valueOf(description.getText());
        image_ = String.valueOf(image.getText());
        level_= String.valueOf(level.getText());
        starttime_ = String.valueOf(starttime.getText());
        endtime_ = String.valueOf(endtime.getText());
        jadwal_ = String.valueOf(jadwal.getText());
        rekening_ = String.valueOf(rekening.getText());
        lokasi_ = String.valueOf(lokasi.getText());
        jam_ = String.valueOf(jam.getText());
        harga_ = String.valueOf(harga.getText());


        //FirebaseFirestore db = FirebaseFirestore.getInstance();
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

// Koleksi A
        String collectionPathA = "Trainer";
        CollectionReference collectionRefA = fStore.collection(collectionPathA);

        Map<String, Object> dataTrainer = new HashMap<>();
        dataTrainer.put("userId", userId); // Tambahkan ID pengguna saat ini
        dataTrainer.put("speciality", speciality_);
        dataTrainer.put("experience", experience_);
        dataTrainer.put("certification", certification_);
// Tambahkan data lainnya untuk dokumen A1

        collectionRefA.add(dataTrainer)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // Dokumen A1 berhasil ditambahkan
                        String documentIdA1 = documentReference.getId();
                        // Lakukan sesuatu dengan ID dokumen A1 jika diperlukan
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Gagal menambahkan dokumen A1
                        Log.e(TAG, "Error adding document A1: " + e.getMessage());
                    }
                });

       /* Map<String, Object> dataKelas = new HashMap<>();
        dataKelas.put("userId", userId); // Tambahkan ID pengguna saat ini
        dataKelas.put("field1", value2); // Tambahkan data 2
// Tambahkan data lainnya untuk dokumen A2

        collectionRefA.add(dataA2)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // Dokumen A2 berhasil ditambahkan
                        String documentIdA2 = documentReference.getId();
                        // Lakukan sesuatu dengan ID dokumen A2 jika diperlukan
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Gagal menambahkan dokumen A2
                        Log.e(TAG, "Error adding document A2: " + e.getMessage());
                    }
                });*/

// Koleksi B
        String collectionPathB = "Kelas";
        CollectionReference collectionRefB = fStore.collection(collectionPathB);

        Map<String, Object> dataKelas = new HashMap<>();
        dataKelas.put("TrainerId", userId); // Tambahkan ID pengguna saat ini
        dataKelas.put("judul", judul_);
        dataKelas.put("description",description_);
        dataKelas.put("image", image_);
        dataKelas.put("level", level_);
        dataKelas.put("starttime", starttime_);
        dataKelas.put("endtime", endtime_);
        dataKelas.put("jadwal", jadwal_);
        dataKelas.put("rekening", rekening_);
        dataKelas.put("lokasi", lokasi_);
        dataKelas.put("jam", jam_);
        dataKelas.put("harga", harga_);

        // Tambahkan data 3
// Tambahkan data lainnya untuk dokumen B1

        collectionRefB.add(dataKelas)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // Dokumen B1 berhasil ditambahkan
                        String documentIdB1 = documentReference.getId();

                        Intent intent = new Intent(FormKelasActivity.this, Profil.class);
                        startActivity(intent);// Lakukan sesuatu dengan ID dokumen B1 jika diperlukan
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Gagal menambahkan dokumen B1
                        Log.e(TAG, "Error adding document B1: " + e.getMessage());
                    }
                });

    }
}