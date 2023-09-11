package com.example.fitpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MenuDiet extends AppCompatActivity {
    private TextView text_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_diet);
        text_view = findViewById(R.id.tle1);
        text_view.setOnClickListener((v -> {
            if (v.getId() == R.id.tle1) {
                Intent balik = new Intent(MenuDiet.this, ResepActivity.class);
                startActivity(balik);
            }
        }
        ));
    }
}