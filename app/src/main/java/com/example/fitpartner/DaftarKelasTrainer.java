package com.example.fitpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DaftarKelasTrainer extends AppCompatActivity {
    TextView judul, jadwal, jam, harga, user,TrainerId, description, lokasi, periode, level, rekening, starttime;
    Button buktibayar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_kelas_trainer);

        judul = findViewById(R.id.judul_id);
        jadwal = findViewById(R.id.jadwal_id);
        jam = findViewById(R.id.jam_id);
        lokasi = findViewById(R.id.lokasi_id);
        starttime = findViewById(R.id.starttime_id);
        level = findViewById(R.id.level_id);
        rekening = findViewById(R.id.rekening_id);
        harga = findViewById(R.id.harga_id);
        TrainerId = findViewById(R.id.user_id);
        buktibayar = findViewById(R.id.buktibayar);

        judul.setText(getIntent().getStringExtra("judul"));
        jadwal.setText(getIntent().getStringExtra("jadwal"));
        jam.setText(getIntent().getStringExtra("jam"));
        harga.setText(getIntent().getStringExtra("harga"));
        rekening.setText(getIntent().getStringExtra("rekening"));
        level.setText(getIntent().getStringExtra("level"));
        starttime.setText(getIntent().getStringExtra("starttime"));
        lokasi.setText(getIntent().getStringExtra("lokasi"));
        TrainerId.setText(getIntent().getStringExtra("TrainerId"));

        buktibayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentbayar = new Intent(DaftarKelasTrainer.this, BayarKelasActivity.class);
                intentbayar.putExtra("judul", getIntent().getStringExtra("judul"));
                intentbayar.putExtra("jadwal", getIntent().getStringExtra("jadwal"));
                intentbayar.putExtra("jam", getIntent().getStringExtra("jam"));
                intentbayar.putExtra("harga", getIntent().getStringExtra("harga"));
                intentbayar.putExtra("lokasi", getIntent().getStringExtra("lokasi"));
                intentbayar.putExtra("rekening", getIntent().getStringExtra("rekening"));
                intentbayar.putExtra("level", getIntent().getStringExtra("level"));
                intentbayar.putExtra("starttime", getIntent().getStringExtra("starttime"));
                intentbayar.putExtra("TrainerId", getIntent().getStringExtra("TrainerId"));
                intentbayar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentbayar);
            }
        });
    }
}
