package com.example.fitpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainModelKelas extends AppCompatActivity {
    String  jadwal, jam;
    String judul;
    String url;


    MainModelKelas(){

    }
    public MainModelKelas(String judul, String jadwal, String jam) {
        this.judul = judul;
        this.jadwal = jadwal;
        this.jam = jam;
        this.url =url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_model_kelas);
    }
}