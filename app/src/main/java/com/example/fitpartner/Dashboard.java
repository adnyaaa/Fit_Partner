package com.example.fitpartner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        CardView kelasCard = findViewById(R.id.kelas);
        CardView profilCard = findViewById(R.id.profil);
        CardView menuSehatCard = findViewById(R.id.menu_sehat);

        kelasCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, MainActivityKelas.class);
                startActivity(intent);
            }
        });

        profilCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Profil.class);
                startActivity(intent);
            }
        });

        menuSehatCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, MenuDiet.class);
                startActivity(intent);
            }
        });

    }
}