package com.example.fitpartner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Profil extends AppCompatActivity {
    private ArrayList<model> datalist1, datalist2, datalist3, datalist4;
    Button button_logout, button_dftr, Button;
    myadapterprofile MyAdapter1, MyAdapter3;
    myadapterprofile2 MyAdapter2;
    myadapter MyAdapter4;

    FirebaseAuth auth;
    TextView data_username;
    FirebaseUser user;
    private EditText edtusername;
    private EditText edtpassword;
    private EditText edtnama;
    private EditText edtemail;
    private ImageView imageView;
    public static final String NAMA_KELAS = "nama_kelas";
    public static final String JAM_KELAS = "jam_kelas";
    public static final String DURASI_KELAS = "durasi_kelas";
    public static final String DESKRIPSI_KELAS = "deskripsi_kelas";
    private int myVar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        auth = FirebaseAuth.getInstance();
        button_logout = findViewById(R.id.logout);
        button_dftr = findViewById(R.id.daftar);
        data_username = findViewById(R.id.tv_data_username);
        user = auth.getCurrentUser();
        String currentUserId = auth.getCurrentUser().getUid();
        if (user == null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            data_username.setText(user.getEmail());
        }
        button_dftr.setOnClickListener((v) -> {
            if (v.getId() == R.id.daftar) {
                Intent balik = new Intent(Profil.this, FormKelasActivity.class);
                startActivity(balik);
            }
        });
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        RecyclerView recyclerView1 = findViewById(R.id.recycler1);
        RecyclerView recyclerView2 = findViewById(R.id.recycler2);
        RecyclerView recyclerView3 = findViewById(R.id.recycler3);

        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        /*LinearLayoutManager userManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(userManager);

        LinearLayoutManager listManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(listManager);*/

        datalist1 = new ArrayList<>();
        datalist2 = new ArrayList<>();
        datalist3 = new ArrayList<>();
        datalist4 = new ArrayList<>();

        MyAdapter1 = new myadapterprofile(datalist1);
        MyAdapter2 = new myadapterprofile2(datalist2);
        //MyAdapter4 = new myadapter(datalist2);
        MyAdapter4 = new myadapter(datalist4);


        recyclerView3.setAdapter(MyAdapter4);
        recyclerView1.setAdapter(MyAdapter2);
        recyclerView2.setAdapter(MyAdapter1);
        //recyclerView3.setAdapter(MyAdapter2);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        /*db.collection("Kelas").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list= queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            model obj=d.toObject(model.class);
                            datalist.add(obj);

                        }
                        adapter.notifyDataSetChanged();

                    }
                });


        /*db.collection("Pembayaran")
                .whereEqualTo("status", "pending")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            model obj = d.toObject(model.class);
                            datalist1.add(obj);
                        }
                        MyAdapter1.notifyDataSetChanged();
                    }
                });*/

        db.collection("Pembayaran")
                .whereEqualTo("status", "terkonfirmasi")
                .whereEqualTo("userId", currentUserId)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            model obj = d.toObject(model.class);
                            datalist2.add(obj);
                        }
                        MyAdapter2.notifyDataSetChanged();
                    }
                });
        db.collection("Pembayaran")
                .whereEqualTo("status", "pending")
                .whereEqualTo("TrainerId", currentUserId)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            model obj = d.toObject(model.class);
                            datalist1.add(obj);
                        }
                        MyAdapter1.notifyDataSetChanged();
                    }
                });

        /*db.collection("Pembayaran")
                .whereEqualTo("userId", currentUserId)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            model obj = d.toObject(model.class);
                            datalist1.add(obj);
                        }
                        MyAdapter1.notifyDataSetChanged();
                    }
                });*/

        db.collection("Kelas")
                .whereEqualTo("TrainerId", currentUserId)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            model obj = d.toObject(model.class);
                            datalist4.add(obj);
                        }
                        MyAdapter4.notifyDataSetChanged();
                    }
                });




    }
        /*db.collection("Kelas")
                .whereEqualTo("userId",currentUserId ) // Filter data berdasarkan userId yang sama dengan user yang sedang login
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            model obj = d.toObject(model.class);
                            datalist1.add(obj);
                        }
                        MyAdapter1.notifyDataSetChanged();
                    }
                });

        db.collection("Pembayaran").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            model obj = d.toObject(model.class);
                            datalist2.add(obj);
                        }
                        MyAdapter2.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Handle the failure
                    }
                });
       /* BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        // Tambahkan kode yang ingin dijalankan ketika item "navigation_home" diklik.
                        // Misalnya:
                        // Intent moveIntentMenu = new Intent(Profil.this, MenudietActivity.class);
                        // startActivity(moveIntentMenu);
                        return true;
                    case R.id.navigation_daftarkelas:
                        // Tambahkan kode yang ingin dijalankan ketika item "navigation_daftarkelas" diklik.
                        // Misalnya:
                        Intent moveIntentDaftarkelas = new Intent(Profil.this, MainActivityKelas.class);
                        startActivity(moveIntentDaftarkelas);
                        return true;
                }
                return false;
            }
        });*/
    }

