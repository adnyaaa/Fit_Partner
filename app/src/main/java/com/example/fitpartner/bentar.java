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

import java.util.ArrayList;

public class bentar extends RecyclerView.Adapter<bentar.myviewholder>
{
    ArrayList<model> datalist1;

    public bentar(ArrayList<model> datalist) {
        this.datalist1 = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow1,parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myviewholder holder, final int position) {
        holder.title_id.setText(datalist1.get(position).getHarga());
        holder.status_id.setText(datalist1.get(position).getStatus());
        //holder.jam_id.setText(datalist1.get(position).getJam());
        holder.statuspembayaran_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.daftar.getContext(), DetailStatusPembayaran.class);
                intent.putExtra("status",datalist1.get(position).getStatus());
                intent.putExtra("name",datalist1.get(position).getName());
                intent.putExtra("rekening",datalist1.get(position).getName());
                intent.putExtra("nominal",datalist1.get(position).getNominal());
                intent.putExtra("namabank",datalist1.get(position).getNamabank());
                intent.putExtra("jadwal",datalist1.get(position).getJadwal());
                intent.putExtra("userId",datalist1.get(position).getUserid());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.statuspembayaran_id.getContext().startActivity(intent);
            }

        });
        /*holder.bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentbayar = new Intent(holder.bayar.getContext(), DaftarKelasTrainer.class);
                intentbayar.putExtra("judul",datalist.get(position).getJudul());
                intentbayar.putExtra("jadwal",datalist.get(position).getJadwal());
                intentbayar.putExtra("jam",datalist.get(position).getJam());
                intentbayar.putExtra("harga",datalist.get(position).getHarga());
                intentbayar.putExtra("lokasi",datalist.get(position).getLokasi());
                intentbayar.putExtra("rekening",datalist.get(position).getRekening());
                intentbayar.putExtra("level",datalist.get(position).getLevel());
                intentbayar.putExtra("starttime",datalist.get(position).getStarttime());
                intentbayar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.bayar.getContext().startActivity(intentbayar);

            }
        });*/



        /*String imageUrl = datalist.get(position).getImgUrl();
        Picasso.get().load(imageUrl).into(holder.nkh);*/

    }

    @Override
    public int getItemCount() {
        return datalist1.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{


        Button daftar, bayar;
        TextView title_id, jadwal_id,status_id, jam_id, judul_id, harga_id, description_id, rekening_id, statuspembayaran_id;
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
            status_id = itemView.findViewById(R.id.status_id);
            statuspembayaran_id = itemView.findViewById(R.id.statuspembayaran_id);


        }

    }
}