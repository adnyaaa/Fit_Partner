package com.example.fitpartner;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    ArrayList<model> datalist;

    public myadapter(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myviewholder holder, final int position) {
        holder.title_id.setText(datalist.get(position).getJudul());
        holder.jam_id.setText(datalist.get(position).getJam());
        holder.jadwal_id.setText(datalist.get(position).getJadwal());
        holder.jam_id.setText(datalist.get(position).getJam());
        /*holder.daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.daftar.getContext(), DetailKelas.class);
                intent.putExtra("judul",datalist.get(position).getJudul());
                intent.putExtra("jadwal",datalist.get(position).getJadwal());
                intent.putExtra("jam",datalist.get(position).getJam());
                intent.putExtra("harga",datalist.get(position).getHarga());

                intent.putExtra("description",datalist.get(position).getDescription());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.daftar.getContext().startActivity(intent);
            }

        });*/
        holder.daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentbayar = new Intent(holder.daftar.getContext(), DaftarKelasTrainer.class);
                intentbayar.putExtra("judul",datalist.get(position).getJudul());
                intentbayar.putExtra("jadwal",datalist.get(position).getJadwal());
                intentbayar.putExtra("jam",datalist.get(position).getJam());
                intentbayar.putExtra("harga",datalist.get(position).getHarga());
                intentbayar.putExtra("lokasi",datalist.get(position).getLokasi());
                intentbayar.putExtra("rekening",datalist.get(position).getRekening());
                intentbayar.putExtra("level",datalist.get(position).getLevel());
                intentbayar.putExtra("starttime",datalist.get(position).getStarttime());
                intentbayar.putExtra("TrainerId", datalist.get(position).getTrainerId());
                intentbayar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.daftar.getContext().startActivity(intentbayar);

            }
        });



        /*String imageUrl = datalist.get(position).getImgUrl();
        Picasso.get().load(imageUrl).into(holder.nkh);*/

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{


        Button daftar, bayar;
        TextView title_id, jadwal_id, jam_id, judul_id, harga_id, description_id, rekening_id;
        ImageView nkh;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            title_id= itemView.findViewById(R.id.title_id);
            jadwal_id= itemView.findViewById(R.id.jadwal_id);
            jam_id= itemView.findViewById(R.id.jam_id);
            judul_id= itemView.findViewById(R.id.judul_id);
            harga_id= itemView.findViewById(R.id.harga_id);
            rekening_id= itemView.findViewById(R.id.rekening_id);
            description_id= itemView.findViewById(R.id.description_id);
            daftar = itemView.findViewById(R.id.daftar);
            bayar = itemView.findViewById(R.id.bayar);


        }

    }
}
