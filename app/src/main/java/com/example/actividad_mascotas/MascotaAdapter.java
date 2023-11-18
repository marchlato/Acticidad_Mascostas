package com.example.actividad_mascotas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {
    private List<Mascota> mascotas;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Mascota mascota);
    }

    public MascotaAdapter(List<Mascota> mascotas, OnItemClickListener listener) {
        this.mascotas = mascotas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false);
        return new MascotaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.bind(mascota, listener);
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreTextView;
        private ImageView ratingImageView;
        private ImageView mascotaImageView;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            ratingImageView = itemView.findViewById(R.id.ratingImageView);
            mascotaImageView = itemView.findViewById(R.id.mascotaImageView); // Agregar esta línea

        }

        public void bind(final Mascota mascota, final OnItemClickListener listener) {
            nombreTextView.setText(mascota.getNombre());
            ratingImageView.setImageResource(mascota.getRating() > 1 ? R.drawable.hueso2 : R.drawable.hueso1);

            mascotaImageView.setImageResource(mascota.getImagen());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(mascota);
                }
            });
        }
    }
}