package com.example.fitpartner;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.annotations.NonNull;

public class DetailStatusPembayaran extends AppCompatActivity {
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    EditText verivikasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView nama, nama_bank_id, rekening, nominal;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_status_pembayaran);
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        CollectionReference collectionRef = firestore.collection("Pembayaran");

        String userId = "userId";
        nama = findViewById(R.id.name_id);
        nama_bank_id = findViewById(R.id.nama_bank_id);
        nominal = findViewById(R.id.nominal_id);
        rekening = findViewById(R.id.rekening_id);



        nama.setText(getIntent().getStringExtra("name"));
        nama_bank_id.setText(getIntent().getStringExtra("namabank"));
        nominal.setText(getIntent().getStringExtra("nominal"));
        String documentId = getIntent().getStringExtra("documentId");
        rekening.setText(getIntent().getStringExtra("rekening"));
        /*String trainerId = intent.getStringExtra("TrainerId");
        String judul_ = intent.getStringExtra("judul");
        String jadwal_= intent.getStringExtra("jadwal");
        String lokasi_= intent.getStringExtra("lokasi");
        String name = intent.getStringExtra("name");
        String nominal_ = intent.getStringExtra("nominal");*/
        Button konfirmasi = findViewById(R.id.konfirmasi);
        konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String documentId = getIntent().getStringExtra("documentId");
                if (documentId != null) {
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    DocumentReference documentRef = db.collection("Pembayaran").document(documentId);

                    documentRef.update("status", "terkonfirmasi")
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(DetailStatusPembayaran.this, "Status updated successfully", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(DetailStatusPembayaran.this, "Failed to update status", Toast.LENGTH_SHORT).show();
                                    ;
                                }
                            });
                } else {
                    Toast.makeText(DetailStatusPembayaran.this, "....", Toast.LENGTH_SHORT).show();

                }
                Intent intent = new Intent(DetailStatusPembayaran.this, Profil.class);
                startActivity(intent);
            }
        });




    }

}
