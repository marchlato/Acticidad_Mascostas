package com.example.actividad_mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FavoritasMascotas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas_mascotas);


        // Inicializar datos de ejemplo para las mascotas favoritas
        List<Mascota> mascotasFavoritas = new ArrayList<>();
        mascotasFavoritas.add(new Mascota("Favorita 1", 4, R.drawable.mascota1));
        mascotasFavoritas.add(new Mascota("Favorita 2", 5, R.drawable.mascota2));
        mascotasFavoritas.add(new Mascota("Favorita 3", 3, R.drawable.mascota3));
        mascotasFavoritas.add(new Mascota("Favorita 4", 2,R.drawable.mascota4));
        mascotasFavoritas.add(new Mascota("Favorita 5", 1,R.drawable.mascota5));

        // Configurar RecyclerView para mostrar mascotas favoritas
        RecyclerView recyclerView = findViewById(R.id.favoritasRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MascotaAdapter adapter = new MascotaAdapter(mascotasFavoritas, new MascotaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Mascota mascota) {
                // Lógica para manejar clics en elementos de la lista (puedes implementar según tus necesidades)
                Toast.makeText(FavoritasMascotas.this, "Hiciste clic en " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
