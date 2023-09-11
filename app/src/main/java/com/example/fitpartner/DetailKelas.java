package com.example.fitpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailKelas extends AppCompatActivity {
    TextView judul, jadwal, jam, harga,TrainerId, description,lokasi, starttime, level, user;
    Button bayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actviity_detailkelas);

        judul = findViewById(R.id.judul_id);
        jadwal = findViewById(R.id.jadwal_id);
        jam = findViewById(R.id.jam_id);
        harga = findViewById(R.id.harga_id);
        description = findViewById(R.id.description_id);
        lokasi = findViewById(R.id.lokasi_id);
        starttime = findViewById(R.id.starttime_id);
        level = findViewById(R.id.level_id);
        TrainerId = findViewById(R.id.user_id);
        bayar = findViewById(R.id.bayar);

        judul.setText(getIntent().getStringExtra("judul"));
        jadwal.setText(getIntent().getStringExtra("jadwal"));
        jam.setText(getIntent().getStringExtra("jam"));
        harga.setText(getIntent().getStringExtra("harga"));
        lokasi.setText(getIntent().getStringExtra("lokasi"));
        starttime.setText(getIntent().getStringExtra("starttime"));
        level.setText(getIntent().getStringExtra("level"));
        TrainerId.setText(getIntent().getStringExtra("TrainerId"));
        description.setText(getIntent().getStringExtra("description"));


        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentbayar = new Intent(DetailKelas.this, DaftarKelasTrainer.class);
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
