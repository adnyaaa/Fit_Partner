package com.example.fitpartner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainAdapter extends FirestoreRecyclerAdapter<MainModelKelas, MainAdapter.myViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */


public MainAdapter(@NonNull FirestoreRecyclerOptions<MainModelKelas> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModelKelas model) {
        holder.title_id.setText(model.getJudul());
        holder.jadwal_id.setText(model.getJadwal());
        holder.jam_id.setText(model.getJam());

        Glide.with(holder.img.getContext())
                .load(model.getUrl())
                .placeholder(R.drawable.nkh)
                .circleCrop()
                .error(R.drawable.nkh)
                .into(holder.img);


    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainitem_kelas,parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title_id, jadwal_id, jam_id;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.img1);
            title_id = (TextView)itemView.findViewById(R.id.title_id);
            jadwal_id = (TextView)itemView.findViewById(R.id.jadwal_id);
            jam_id = (TextView)itemView.findViewById(R.id.jam_id);

        }
    }



}
