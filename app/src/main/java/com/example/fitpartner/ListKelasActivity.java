package com.example.fitpartner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;

public class ListKelasActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kelas);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirestoreRecyclerOptions<MainModelKelas> options = new FirestoreRecyclerOptions.Builder<MainModelKelas>()
                .setQuery(FirebaseFirestore.getInstance().collection("Kelas"), MainModelKelas.class)
                .build();

        mainAdapter= new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);


    }
    @Override
    public void onStart() {
        super.onStart();
        mainAdapter.startListening();}
    @Override
    public void onStop() {

        super.onStop();
        mainAdapter.stopListening();
    }
}